package com.powder.powdertest

interface GetVideosInteractor {
    suspend operator fun invoke(): List<VideoEntity>
}

internal fun getVideosInteractor(repository: VideosRepository) =
    object : GetVideosInteractor {
        override suspend fun invoke() = repository.getVideos()
    }