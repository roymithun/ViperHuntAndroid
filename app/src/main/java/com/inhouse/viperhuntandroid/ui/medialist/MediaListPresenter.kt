package com.inhouse.viperhuntandroid.ui.medialist

import android.util.Log
import com.inhouse.viperhuntandroid.app.models.Media
import kotlinx.coroutines.*

class MediaListPresenter(
    private val router: MediaListContract.Router,
    private val interactor: MediaListContract.Interactor
) : MediaListContract.Presenter {
    companion object {
        const val TAG = "MediaListPresenter"
    }

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    var view: MediaListContract.View? = null
    override fun bindView(view: MediaListContract.View) {
        this.view = view
    }

    override fun unbindView() {
        this.view = null
    }

    override fun onQueryTextSubmit(query: String) {
        uiScope.launch {
            view?.showLoading()
            val mediaList = withContext(Dispatchers.IO) {
                interactor.getMediaList(query)
            }
            Log.d(TAG, "onQueryTextSubmit media ${mediaList.results[0].releaseDate}")
            view?.publishData(mediaList.results)
            view?.hideLoading()
        }
    }

    override fun onItemClicked(media: Media) {
        router.openMediaDetails(media)
    }
}