package com.inhouse.viperhuntandroid.ui.medialist

import com.inhouse.viperhuntandroid.app.models.Media
import com.inhouse.viperhuntandroid.app.models.MediaList

interface MediaListContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<Media>)
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun onQueryTextSubmit(query: String)
        fun onItemClicked(media: Media)
    }

    interface Interactor {
        suspend fun getMediaList(searchTerm: String): MediaList
    }

    interface Router {
        fun openMediaDetails(media: Media)
    }

    interface Repo {
        suspend fun getMediaList(searchTerm: String): MediaList
    }
}