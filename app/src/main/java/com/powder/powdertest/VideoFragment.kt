package com.powder.powdertest

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.fragment_video.*

class VideoFragment : Fragment(R.layout.fragment_video) {
    lateinit var video: VideoEntity
    private val exoPlayer: ExoPlayer by lazy {
        val userAgent = Util.getUserAgent(requireContext(), requireContext().packageName)
        val dataSourceFactory = DefaultDataSourceFactory(requireContext(), userAgent)
        val uri = Uri.parse(video.url)
        val source = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        SimpleExoPlayer.Builder(requireContext()).build().apply { prepare(source) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
        playerView.player = exoPlayer
        textView_video_title.text = video.title
    }

    override fun onPause() {
        super.onPause()
        exoPlayer.playWhenReady = false
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer.release()
    }

    fun getInstance(video: VideoEntity): Fragment = VideoFragment().apply { this.video = video }
}