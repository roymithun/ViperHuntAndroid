package com.inhouse.viperhuntandroid.ui.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inhouse.viperhuntandroid.app.BaseApplication
import com.inhouse.viperhuntandroid.databinding.FragmentSplashBinding
import com.inhouse.viperhuntandroid.ui.splash.di.SplashComponent
import javax.inject.Inject

class SplashFragment : Fragment(), SplashContract.View {
    @Inject
    lateinit var presenter: SplashPresenter

    private val splashComponent: SplashComponent by lazy {
        (requireActivity().application as BaseApplication).appComponent.splashComponent()
            .create(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSplashBinding.inflate(layoutInflater)
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        splashComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }
}