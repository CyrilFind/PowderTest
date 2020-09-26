package com.powder.powdertest

import android.content.res.Resources
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class NetworkVideoDataSource(private val videosApi: VideosApi) : VideosDataSource {
    override fun getVideos() = videosApi.getVideos()
}
