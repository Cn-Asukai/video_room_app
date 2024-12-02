package com.example.video_room.network

import com.example.video_room.model.Video
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.scalars.ScalarsConverterFactory


private const val BASE_URL = "http://192.168.1.42:8000"
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface VideoApiService {
    @GET("video/list")
    suspend fun getList(): String
}

object VideoApi {
    val retrofitService: VideoApiService by lazy {
        retrofit.create(VideoApiService::class.java)
    }
}