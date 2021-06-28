package com.inhouse.viperhuntandroid.ui.medialist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.inhouse.viperhuntandroid.app.BaseApplication
import com.inhouse.viperhuntandroid.app.models.Media
import com.inhouse.viperhuntandroid.databinding.FragmentMediaListBinding
import com.inhouse.viperhuntandroid.ui.medialist.adapter.MediaListAdapter
import com.inhouse.viperhuntandroid.ui.medialist.di.MediaListComponent
import javax.inject.Inject

class MediaListFragment : Fragment(), MediaListContract.View {
    companion object {
        val TAG = MediaListFragment::class.simpleName
    }

    @Inject
    lateinit var presenter: MediaListContract.Presenter
    private lateinit var binding: FragmentMediaListBinding
    private val mediaListComponent: MediaListComponent by lazy {
        (requireActivity().application as BaseApplication)
            .appComponent
            .mediaListComponent()
            .create(this)
    }

    private val adapter: MediaListAdapter by lazy {
        MediaListAdapter(object : MediaListAdapter.ItemClickListener {
            override fun onItemClicked(media: Media) {
                presenter.onItemClicked(media)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMediaListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureMediaList()
        binding.svMedia.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG, "onQueryTextSubmit = $query")
                query?.let { presenter.onQueryTextSubmit(it) }
                binding.svMedia.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d(TAG, "onQueryTextChange = $newText")
                return true
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mediaListComponent.inject(this)
    }

    private fun configureMediaList() {
        binding.rvMediaSearchResult.adapter = adapter
    }

    override fun showLoading() {
        binding.progressLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressLoading.visibility = View.GONE
    }

    override fun publishData(data: List<Media>) {
        adapter.submitList(data)
    }

    override fun showMessage(msg: String) {
        TODO("Not yet implemented")
    }
}