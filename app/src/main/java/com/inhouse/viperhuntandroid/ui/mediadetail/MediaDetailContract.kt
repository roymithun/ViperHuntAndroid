package com.inhouse.viperhuntandroid.ui.mediadetail

import com.inhouse.viperhuntandroid.app.models.Media

interface MediaDetailContract {
    interface View {
        fun publishData(media: Media)
    }

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun onViewCreated(media: Media)
    }
}