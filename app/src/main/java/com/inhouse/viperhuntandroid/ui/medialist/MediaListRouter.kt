package com.inhouse.viperhuntandroid.ui.medialist

import androidx.navigation.fragment.findNavController
import com.inhouse.viperhuntandroid.app.models.Media

class MediaListRouter(private val fragment: MediaListFragment) : MediaListContract.Router {
    override fun openMediaDetails(media: Media) {
        fragment.findNavController()
            .navigate(MediaListFragmentDirections.actionMediaListFragmentToMediaDetailFragment(media))
    }
}