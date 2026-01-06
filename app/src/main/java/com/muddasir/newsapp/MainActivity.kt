package com.muddasir.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muddasir.newsapp.data.sealedmodels.UIState
import com.muddasir.newsapp.modules.news.uiscreens.ErrorScreen
import com.muddasir.newsapp.modules.news.uiscreens.LoadingContent
import com.muddasir.newsapp.modules.news.uiscreens.NewsAppScreen
import com.muddasir.newsapp.modules.news.viewmodel.NewsViewModel
import com.muddasir.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val newsViewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun DemoComposable() {
    BoxWithConstraints(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text("hello")
        }
    }
}

@Composable
fun Greeting() {
    val newsViewModel: NewsViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        newsViewModel.getGithubRepository()
    }
    val uiState = newsViewModel.uiState.collectAsState()

    key(uiState.value) {
        Log.e("inside", uiState.toString())
        when (uiState.value) {
            is UIState.Idle,
            is UIState.Loading -> {
                Log.e("inside", "Loading")
                LoadingContent()
            }

            is UIState.Success<*> -> {
                Log.e("inside", "Success")
                NewsAppScreen(
                    newsData = uiState.value,
                    Modifier
                )
            }

            is UIState.Failed -> ErrorScreen()
            else -> {}
        }
    }

}


