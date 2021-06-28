package com.inhouse.viperhuntandroid

import com.inhouse.viperhuntandroid.app.models.Media

class TestData {
    private fun getDummyData(): List<Media> {
        val mediaList = ArrayList<Media>()
        for (i in 0..10) {
            mediaList.add(
                Media(
                    123 + i,
                    123 + i,
                    123 + i,
                    "artist $i",
                    "collection $i",
                    "track $i",
                    "url $i",
                    "previewUrl $i"
                )
            )
        }
        return mediaList
    }
}