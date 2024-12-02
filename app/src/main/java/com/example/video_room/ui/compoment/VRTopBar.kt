package com.example.video_room.ui.compoment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.video_room.R

@Composable
fun TopTextButton(
    label: String,
    onClick: () -> Unit,
    index: Int,
    selectedIndex: Int,
    modifier: Modifier
) {
    val selected = index == selectedIndex
    TextButton(
        onClick, modifier = modifier,
        enabled = !selected
    ) {
        Text(
            label,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp)),
            color = when (selected) {
                true -> Color(0xFF000000)
                false -> Color(0xff5d6c74)
            },
            textDecoration = when (selected) {
                true -> TextDecoration.Underline
                false -> TextDecoration.None
            },
            fontWeight = when (selected) {
                true -> FontWeight.Bold
                false -> FontWeight.Normal
            },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TobBar(itemsName: Array<String>) {

    var selectIndex by remember { mutableIntStateOf(0) }

    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painterResource(id = R.drawable.head_iamge),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )
        }
        itemsName.forEachIndexed { index, item ->
            TopTextButton(
                item,
                { selectIndex = index },
                index,
                selectIndex,
                modifier = Modifier.weight(1f)
            )
        }
        IconButton({}) {
            Icon(
                Icons.Filled.Search, contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            )
        }
    }
}