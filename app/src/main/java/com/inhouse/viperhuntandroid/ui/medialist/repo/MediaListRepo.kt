package com.inhouse.viperhuntandroid.ui.medialist.repo

import com.inhouse.viperhuntandroid.app.models.MediaList
import com.inhouse.viperhuntandroid.ui.medialist.MediaListContract
import com.inhouse.viperhuntandroid.ui.medialist.api.MediaListApi
import javax.inject.Inject

class MediaListRepo @Inject constructor(private val mediaListApi: MediaListApi) :
    MediaListContract.Repo {
    override suspend fun getMediaList(searchTerm: String): MediaList {
        return mediaListApi.getMediaList("music", "song", searchTerm)
    }
}