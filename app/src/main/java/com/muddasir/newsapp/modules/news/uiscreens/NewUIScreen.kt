package com.muddasir.newsapp.modules.news.uiscreens

import android.util.Log
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muddasir.newsapp.data.models.GithubApiReposModel
import com.muddasir.newsapp.data.sealedmodels.UIState
import com.muddasir.newsapp.modules.news.viewmodel.NewsViewModel

@Composable
fun NewsAppScreen(newsData: UIState<GithubApiReposModel>, modifier: Modifier) {
    val newsViewModel: NewsViewModel = hiltViewModel()

    SearchWithListPreview()
    // print(newsData.toString())
}

@Composable
fun LoadingContent() {
    BoxWithConstraints(modifier = Modifier
        .statusBarsPadding()
        .fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            // NewsCardItem()
        }
    }
}

@Composable
fun ErrorScreen() {
    val newsViewModel: NewsViewModel = hiltViewModel()
}
@Preview
@Composable
fun LazyColumnDemo() {
    val list = listOf(
        "A", "B", "C", "D"
    ) + ((0..5).map { it.toString() })
    LazyColumn(modifier = Modifier.padding(horizontal = 10.dp).fillMaxHeight()) {
        items(items = list, itemContent = { item ->
            Log.d("COMPOSE", "This get rendered $item")
            when (item) {
                "A" -> {
                    Text(text = item, style = TextStyle(fontSize = 80.sp))
                }
                "B" -> {
                    Button(onClick = {}) {
                        Text(text = item, style = TextStyle(fontSize = 80.sp))
                    }
                }
                "C" -> {
                    //Do Nothing
                }
                "D" -> {
                    Text(text = item)
                }
                else -> {
                    Text(text = item, style = TextStyle(fontSize = 80.sp))
                }
            }
        })
    }
}
