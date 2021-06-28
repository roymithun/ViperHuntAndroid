package com.inhouse.viperhuntandroid.ui.splash

class SplashContract {
    interface View

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun onViewCreated()
    }

    interface Router {
        fun openMediaList()
    }
}