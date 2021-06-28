package com.inhouse.viperhuntandroid.ui.medialist.di

import com.inhouse.viperhuntandroid.app.di.ActivityScope
import com.inhouse.viperhuntandroid.ui.medialist.MediaListFragment
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MediaListModule::class])
interface MediaListComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: MediaListFragment): MediaListComponent
    }

    fun inject(fragment: MediaListFragment)
}