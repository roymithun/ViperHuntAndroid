package com.inhouse.viperhuntandroid.app.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaList(val results: List<Media>) : Parcelable