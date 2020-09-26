package com.powder.powdertest

interface VideosRepository {
    fun getVideos(): List<VideoEntity>
}
