package com.inhouse.viperhuntandroid.ui.medialist.api

import com.inhouse.viperhuntandroid.app.models.MediaList
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaListApi {
    //    "media=music&entity=song&term=\(searchTerm)"
    @GET("/search")
    suspend fun getMediaList(
        @Query("media") media: String,
        @Query("entity") entity: String,
        @Query("term") term: String
    ): MediaList
}