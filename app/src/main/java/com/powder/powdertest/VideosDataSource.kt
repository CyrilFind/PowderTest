package com.powder.powdertest

interface VideosDataSource {
    fun getVideos(): List<NetworkVideo>
}
