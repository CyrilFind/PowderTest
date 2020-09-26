package com.powder.powdertest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(getVideosInteractor: GetVideosInteractor): ViewModel() {
    private val _videos = MutableLiveData<List<VideoEntity>>()
    val videosLiveData: LiveData<List<VideoEntity>> = _videos

    init {
        viewModelScope.launch {
            _videos.value = getVideosInteractor.invoke()
        }
    }
}