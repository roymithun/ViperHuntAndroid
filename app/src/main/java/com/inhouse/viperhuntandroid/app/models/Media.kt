package com.inhouse.viperhuntandroid.app.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class Media(
    val artistId: Int,
    val collectionId: Int,
    val trackId: Int,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val artworkUrl100: String?,
    val previewUrl: String?,
    val trackPrice: Double?,
    @Json(name = "releaseDate") val releaseDateStr: String,
    val trackTimeMillis: Long
) : Parcelable {
    @IgnoredOnParcel
    private val simpleDatFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
    val releaseDate: Date?
        get() = simpleDatFormat.parse(releaseDateStr)

}