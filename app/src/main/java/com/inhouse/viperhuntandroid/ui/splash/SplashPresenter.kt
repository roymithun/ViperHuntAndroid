package com.inhouse.viperhuntandroid.ui.splash

import kotlinx.coroutines.*

const val SPLASH_DISPLAY_TIME = 2000L

class SplashPresenter(private val router: SplashContract.Router) : SplashContract.Presenter {
    private val job: Job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)
    private var view: SplashContract.View? = null
    override fun bindView(view: SplashContract.View) {
        this.view = view
    }

    override fun unbindView() {
        this.view = null
    }

    override fun onViewCreated() {
        coroutineScope.launch(Dispatchers.IO) {
            delay(SPLASH_DISPLAY_TIME)
            withContext(Dispatchers.Main) {
                router.openMediaList()
            }
        }
    }
}