package com.inhouse.viperhuntandroid.app.di

import com.inhouse.viperhuntandroid.ui.mediadetail.di.MediaDetailComponent
import com.inhouse.viperhuntandroid.ui.medialist.di.MediaListComponent
import com.inhouse.viperhuntandroid.ui.splash.di.SplashComponent
import dagger.Module

@Module(subcomponents = [SplashComponent::class, MediaListComponent::class, MediaDetailComponent::class])
class AppSubComponents
