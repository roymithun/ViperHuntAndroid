package com.inhouse.viperhuntandroid.ui.mediadetail.di

import com.inhouse.viperhuntandroid.app.di.ActivityScope
import com.inhouse.viperhuntandroid.ui.mediadetail.MediaDetailPresenter
import dagger.Module
import dagger.Provides

@Module
class MediaDetailModule {
    @Provides
    @ActivityScope
    fun presenter() = MediaDetailPresenter()
}