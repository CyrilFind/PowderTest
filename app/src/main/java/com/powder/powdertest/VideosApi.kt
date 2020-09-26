package com.powder.powdertest

import retrofit2.http.GET

interface VideosApi {
    @GET("static_feed.json?alt=media&token=c5bbde3a-129b-449e-a79e-d2a0ccffbd0f")
    fun getVideos() : List<NetworkVideo>
}
