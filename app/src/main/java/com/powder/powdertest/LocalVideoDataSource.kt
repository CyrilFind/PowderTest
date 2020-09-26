package com.powder.powdertest

import android.content.res.Resources
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class LocalVideoDataSource(
    private val kotlinxJson: Json,
    private val resources: Resources
) : VideosDataSource {
    override fun getVideos() = resources.openRawResource(R.raw.videos).bufferedReader().use {
        kotlinxJson.decodeFromString(ListSerializer(NetworkVideo.serializer()), it.readText())
    }
}
