package com.inhouse.viperhuntandroid.ui.medialist

import com.inhouse.viperhuntandroid.app.models.Media
import com.inhouse.viperhuntandroid.app.models.MediaList
import com.inhouse.viperhuntandroid.ui.medialist.data.MediaListRepo

class MediaListInteractor(private val repo: MediaListRepo) : MediaListContract.Interactor {
    override suspend fun getMediaList(searchTerm: String): MediaList {
        return repo.getMediaList(searchTerm)
    }
}