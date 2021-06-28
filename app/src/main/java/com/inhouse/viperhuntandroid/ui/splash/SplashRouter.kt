package com.inhouse.viperhuntandroid.ui.splash

import androidx.navigation.fragment.findNavController

class SplashRouter(private val fragment: SplashFragment) : SplashContract.Router {

    override fun openMediaList() {
        fragment.findNavController()
            .navigate(SplashFragmentDirections.actionSplashFragmentToMediaListFragment())
    }
}