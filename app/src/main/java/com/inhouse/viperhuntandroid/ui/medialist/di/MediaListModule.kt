package com.inhouse.viperhuntandroid.ui.medialist.di

import com.inhouse.viperhuntandroid.app.di.ActivityScope
import com.inhouse.viperhuntandroid.ui.medialist.*
import com.inhouse.viperhuntandroid.ui.medialist.api.MediaListApi
import com.inhouse.viperhuntandroid.ui.medialist.data.MediaListRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MediaListModule {
    @Provides
    @ActivityScope
    fun mediaListApi(retrofit: Retrofit): MediaListApi = retrofit.create(MediaListApi::class.java)


    @Provides
    @ActivityScope
    fun router(fragment: MediaListFragment): MediaListContract.Router = MediaListRouter(fragment)

    @Provides
    @ActivityScope
    fun interactor(repo: MediaListRepo): MediaListContract.Interactor = MediaListInteractor(repo)

    @Provides
    @ActivityScope
    fun presenter(
        router: MediaListContract.Router,
        interactor: MediaListContract.Interactor
    ): MediaListContract.Presenter =
        MediaListPresenter(router, interactor)
}