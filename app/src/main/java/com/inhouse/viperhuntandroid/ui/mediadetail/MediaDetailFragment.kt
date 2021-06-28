package com.inhouse.viperhuntandroid.ui.mediadetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.inhouse.viperhuntandroid.R
import com.inhouse.viperhuntandroid.app.BaseApplication
import com.inhouse.viperhuntandroid.app.models.Media
import com.inhouse.viperhuntandroid.databinding.FragmentMediaDetailBinding
import com.inhouse.viperhuntandroid.ui.mediadetail.di.MediaDetailComponent
import javax.inject.Inject

class MediaDetailFragment : Fragment(), MediaDetailContract.View {
    @Inject
    lateinit var presenter: MediaDetailPresenter
    private val detailComponent: MediaDetailComponent by lazy {
        (requireActivity().application as BaseApplication)
            .appComponent
            .mediaDetailComponent()
            .create()
    }
    private lateinit var binding: FragmentMediaDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMediaDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val media: Media = MediaDetailFragmentArgs.fromBundle(requireArguments()).media
        presenter.bindView(this)
        presenter.onViewCreated(media)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        detailComponent.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun publishData(media: Media) {
        Glide.with(requireContext())
            .load(media.artworkUrl100)
            .apply {
                RequestOptions().placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            }
            .into(binding.ivArtistThumbnail)

        binding.tvArtistNameVal.text = media.artistName
        binding.tvTrackNameVal.text = media.trackName
        binding.tvTrackPrice.text = String.format("$%.2f", media.trackPrice)
    }
}