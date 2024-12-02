package com.example.video_room.ui.compoment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.video_room.R
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.vectorResource
import kotlin.emptyArray

data class NavigationItem(val label: String, val icon: ImageVector)

@Composable
fun VRNavigationBar(currentNavigationIndex: Int, onIndexChange: (Int)->Unit) {
    val barItemNames = stringArrayResource(R.array.bar_items)
    var barItems = Array<NavigationItem>(barItemNames.size, {index ->
        val item = barItemNames[index]
        val icon = when(item) {
            "Home" -> Icons.Outlined.Home
            "Friend" -> ImageVector.vectorResource(R.drawable.baseline_people_24)
            "My" -> Icons.Outlined.Person
            else -> ImageVector.vectorResource(R.drawable.baseline_error_24)
        }
        NavigationItem(item, icon)
    })

    return NavigationBar {
        barItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == currentNavigationIndex,
                onClick = {
                    onIndexChange(index)
                },
                icon = {
                    Icon(item.icon, contentDescription = null)
                },
                label = {
                    Text(item.label)
                },
            )
        }
    }
}