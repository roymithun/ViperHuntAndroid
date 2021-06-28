package com.inhouse.viperhuntandroid.app.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://itunes.apple.com"

@Module(includes = [MoshiModule::class])
class NetworkModule {
    @Provides
    fun retrofit(moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL).build()
}