package com.powder.powdertest

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.fragment_video.*

class VideoFragment : Fragment(R.layout.fragment_video) {
    lateinit var video: Video

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userAgent = Util.getUserAgent(requireContext(), requireContext().packageName)
        val dataSourceFactory = DefaultDataSourceFactory(requireContext(), userAgent)
        val uri = Uri.parse(video.url)
        val source = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        val exoPlayer = SimpleExoPlayer.Builder(requireContext()).build().apply { prepare(source) }
        playerView.player = exoPlayer
    }
    fun getInstance(video: Video): Fragment = VideoFragment().apply { this.video = video }
}