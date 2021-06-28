package com.inhouse.viperhuntandroid.app

import android.app.Application
import com.inhouse.viperhuntandroid.app.di.AppComponent
import com.inhouse.viperhuntandroid.app.di.DaggerAppComponent

class BaseApplication : Application() {
//    val appComponent: AppComponent by lazy {
//        DaggerAppComponent.builder()
//            .context(this)
//            .build()
//    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }
}