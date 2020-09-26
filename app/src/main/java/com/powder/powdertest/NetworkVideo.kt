package com.powder.powdertest
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NetworkVideo(
    @SerialName("video_url")
    val url: String,
    @SerialName("title")
    val title: String,
    @SerialName("game")
    val gameTitle: String,
    @SerialName("author")
    val userName: String,
) : java.io.Serializable