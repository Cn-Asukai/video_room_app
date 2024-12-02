package com.example.video_room.data

import com.example.video_room.network.VideoApiService
import com.example.video_room.model.Video

interface VideoRepository {
    suspend fun getVideos(): String
}

class NetworkVideoRepository (
    private val videoApiService: VideoApiService
): VideoRepository {
    override suspend fun getVideos(): String = videoApiService.getList()
}