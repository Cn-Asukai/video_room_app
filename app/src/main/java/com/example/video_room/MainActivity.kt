package com.example.video_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.video_room.ui.compoment.TobBar
import com.example.video_room.ui.compoment.VRNavigationBar
import com.example.video_room.ui.screens.VideoViewModel
//import com.example.video_room.ui.screens.VideoViewModel
import com.example.video_room.ui.theme.VideoRoomTheme


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val view = LocalView.current
            // 隐藏系统导航栏
            SideEffect {
                val windowInsetsController = ViewCompat.getWindowInsetsController(view)
                if (windowInsetsController != null) {
                    windowInsetsController.systemBarsBehavior =
                        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                    windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
                }
            }
            VideoRoomTheme {
                var currentNavigationIndex by remember { mutableIntStateOf(0) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = if (currentNavigationIndex == 0) {
                        {
                            Column {
                                Spacer(
                                    modifier = Modifier
                                        .statusBarsPadding()
                                        .fillMaxWidth()
                                )
                                TobBar(arrayOf("Video", "Room"))
                            }

                        }
                    } else if (currentNavigationIndex == 1) {
                        {
                            Column {
                                Spacer(
                                    modifier = Modifier
                                        .statusBarsPadding()
                                        .fillMaxWidth()
                                )
                                TobBar(arrayOf("Messages", "Posts"))
                            }
                        }
                    } else {
                        {}
                    },
                    bottomBar = {

                        VRNavigationBar(
                            currentNavigationIndex
                        ) { index -> currentNavigationIndex = index }
                    }) { innerPadding ->
                    val videoViewModel: VideoViewModel = viewModel()
                    Column {
                        Box(modifier = Modifier.padding(innerPadding)) {
                            Banner()
                        }
                        Text(videoViewModel.videoUiState)
                    }


                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Banner() {
    val pagerState = rememberPagerState(pageCount = { return@rememberPagerState 3 })

    HorizontalPager(
//        pageCount = 3,
        state = pagerState,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .padding(16.dp)
    ) { index ->
        BannerItem()
    }
}

@Composable
fun BannerItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.head_iamge),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }
}

