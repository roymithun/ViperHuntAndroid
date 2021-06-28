package com.inhouse.viperhuntandroid.ui.splash.di

import com.inhouse.viperhuntandroid.app.di.ActivityScope
import com.inhouse.viperhuntandroid.ui.splash.SplashFragment
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: SplashFragment): SplashComponent
    }

    fun inject(fragment: SplashFragment)
}
