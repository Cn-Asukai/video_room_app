package com.example.video_room.model
import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class Video (
    val id: Int,
    @SerialName(value = "create_at")
    val createdAt: String,
    val name: String,
    val url: String,
    @SerialName(value = "cover_url")
    val coverUrl: String,
    val creator: Int
)


