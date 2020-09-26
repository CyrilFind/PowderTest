package com.powder.powdertest

class DefaultVideosRepository(private val dataSource: VideosDataSource) : VideosRepository {
    override fun getVideos() = dataSource.getVideos()
        .map { it as VideoEntity } // as an example
}