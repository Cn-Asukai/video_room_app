package com.example.video_room.ui.compoment

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector

data class MyRowData(val icon: ImageVector, val content: String)

@Composable
fun MyList() {
    val dataList = listOf(
        MyRowData(Icons.Filled.Settings, "Setting"),
    )

    dataList.forEach { data ->
        MyRow(data)
    }
}

@Composable
private fun MyRow(data: MyRowData) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(data.icon, contentDescription = null)
        Text(data.content)
    }
}