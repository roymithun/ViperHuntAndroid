package com.inhouse.viperhuntandroid.ui.mediadetail

import com.inhouse.viperhuntandroid.app.models.Media

class MediaDetailPresenter : MediaDetailContract.Presenter {
    private var view: MediaDetailContract.View? = null

    override fun bindView(view: MediaDetailContract.View) {
        this.view = view
    }

    override fun unbindView() {
        this.view = null
    }

    override fun onViewCreated(media: Media) {
        view?.publishData(media)
    }
}