package com.inhouse.viperhuntandroid.ui.splash.di

import com.inhouse.viperhuntandroid.app.di.ActivityScope
import com.inhouse.viperhuntandroid.ui.splash.SplashContract
import com.inhouse.viperhuntandroid.ui.splash.SplashFragment
import com.inhouse.viperhuntandroid.ui.splash.SplashPresenter
import com.inhouse.viperhuntandroid.ui.splash.SplashRouter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {
    @Provides
    @ActivityScope
    fun router(fragment: SplashFragment): SplashContract.Router = SplashRouter(fragment)

    @Provides
    @ActivityScope
    fun presenter(router: SplashContract.Router) = SplashPresenter(router)
}
