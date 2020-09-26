package com.powder.powdertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.powder.powdertest.databinding.FragmentVideoBinding

class VideoFragment : Fragment(R.layout.fragment_video) {
    private lateinit var videoViewModel: VideoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FragmentVideoBinding.inflate(inflater).apply {
            lifecycleOwner = this@VideoFragment
            viewModel = videoViewModel
        }.root

    override fun onPause() {
        super.onPause()
        videoViewModel.pause()
    }

    fun getInstance(video: VideoEntity): Fragment = VideoFragment().apply { this.videoViewModel = VideoViewModel(video) }
}