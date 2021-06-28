package com.inhouse.viperhuntandroid.app.di

import com.inhouse.viperhuntandroid.app.di.modules.NetworkModule
import com.inhouse.viperhuntandroid.ui.mediadetail.di.MediaDetailComponent
import com.inhouse.viperhuntandroid.ui.medialist.di.MediaListComponent
import com.inhouse.viperhuntandroid.ui.splash.di.SplashComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubComponents::class, NetworkModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun splashComponent(): SplashComponent.Factory
    fun mediaListComponent(): MediaListComponent.Factory
    fun mediaDetailComponent(): MediaDetailComponent.Factory
}