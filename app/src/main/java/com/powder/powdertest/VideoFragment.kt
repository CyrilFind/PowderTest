package com.powder.powdertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.powder.powdertest.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {
    private val videoViewModel: VideoViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                VideoViewModel(requireArguments().getSerializable("video") as VideoEntity) as T
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FragmentVideoBinding.inflate(inflater).apply {
            lifecycleOwner = this@VideoFragment
            viewModel = videoViewModel
        }.root

    override fun onPause() {
        super.onPause()
        videoViewModel.pause()
    }

    companion object {
        fun newInstance(video: VideoEntity): Fragment = VideoFragment().apply {
            arguments = Bundle().apply { putSerializable("video", video) }
        }
    }
}