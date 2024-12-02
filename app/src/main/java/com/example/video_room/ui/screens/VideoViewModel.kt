package com.example.video_room.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.video_room.data.VideoRepository
import com.example.video_room.model.Video
import com.example.video_room.network.VideoApi
//import com.example.video_room.ui.screens.VideoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

//sealed interface VideoUiState {
//    data class Success(val videos: List<Video>) : VideoUiState
//    object Error : VideoUiState
//    object Loading : VideoUiState
//}
//
//class VideoViewModel(private val videoRepository: VideoRepository) : ViewModel() {
//    // 使用 MutableLiveData 替代 mutableStateOf
//    private val _marsUiState = MutableLiveData<VideoUiState>(VideoUiState.Loading)
//    val marsUiState: LiveData<VideoUiState> = _marsUiState
//
//
//    init {
//        getVideos()
//    }
//
//    fun getVideos() {
//        viewModelScope.launch {
//            _marsUiState.value = VideoUiState.Loading
//            _marsUiState.value = try {
//                VideoUiState.Success(videoRepository.getVideos())
//            } catch (e: Exception) {
//                VideoUiState.Error
//            }
//
//        }
//    }
//}

class VideoViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    private val _videoUiState = MutableStateFlow("")
    val videoUiState: String
        get() = _videoUiState.value


    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getVideos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getVideos() {
        viewModelScope.launch {
            val listResult = VideoApi.retrofitService.getList()
            _videoUiState.value = listResult
        }
    }
}