package com.powder.powdertest

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class VideoViewModel(video: VideoEntity) : ViewModel() {
    val exoPlayer: ExoPlayer by lazy {
        val context = FakeDependencyInjection.context
        val userAgent = Util.getUserAgent(context, context.packageName)
        val dataSourceFactory = DefaultDataSourceFactory(context, userAgent)
        val uri = Uri.parse(video.url)
        val source = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        SimpleExoPlayer.Builder(context).build().apply {
            repeatMode = Player.REPEAT_MODE_ONE
            prepare(source)
        }
    }

    val title = video.title

    override fun onCleared() {
        super.onCleared()
        exoPlayer.release()
    }

    fun pause() {
        exoPlayer.playWhenReady = false
    }
}
