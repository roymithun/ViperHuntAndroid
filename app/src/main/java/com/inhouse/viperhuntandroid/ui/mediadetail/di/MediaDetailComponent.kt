package com.inhouse.viperhuntandroid.ui.mediadetail.di

import com.inhouse.viperhuntandroid.app.di.ActivityScope
import com.inhouse.viperhuntandroid.ui.mediadetail.MediaDetailFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MediaDetailModule::class])
interface MediaDetailComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MediaDetailComponent
    }

    fun inject(fragment: MediaDetailFragment)
}