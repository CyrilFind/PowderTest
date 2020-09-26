package com.powder.powdertest
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkVideo(
    @SerialName("video_url")
    val url: String,
    @SerialName("title")
    val title: String,
)