package com.muddasir.newsapp.modules.news.uiscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muddasir.newsapp.R


@Composable
fun NewsCardItem() {
    Scaffold(modifier = Modifier.background(color = Color.LightGray).fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            GoBackItem() {}
            TopItem()
            Card(
                modifier = Modifier
                    .height(200.dp)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),
                colors = CardColors(
                    contentColor = Color.Cyan, containerColor = Color.Blue,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.White
                )
            ) {

            }
            Text(
                "Lorem ipsum Lorem ipSum",
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(start = 20.dp, end = 20.dp),
                fontSize = 28.sp
            )
            Text(
                "The “1w ago” is generated using the extension function News.timeSince(). It will generate a human-readable date.",
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(start = 20.dp, end = 20.dp),
                fontSize = 16.sp
            )
            LazyColumnDemo()

        }
    }
}


@Composable
fun TopItem(
    publisher: String = "publisher",
    publisherDetails: String = "Publisher Details"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.weight(2f),
            Arrangement.Start, verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.outline_account_circle_24),
                contentDescription = "circular person",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(48.dp)
            )
            Text(
                publisher,
                color = Color.Black,
                modifier = Modifier

                    .padding(start = 10.dp)
            )
        }
        Row(
            modifier = Modifier
                .weight(2f)
                .padding(end = 20.dp), Arrangement.End
        ) {
            Text(
                publisherDetails,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 10.dp)
            )

        }
    }
}

@Preview
@Composable
fun SearchScreen() {
    Scaffold(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        GoBackItem() {}
    }
}


@Composable
fun GoBackItem(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(start = 10.dp)
            .clickable(enabled = true, onClick = {
                onClick()
            })
            .fillMaxWidth()
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.outline_arrow_back_24),
            contentDescription = "back item",
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color.Black)
        )
    }
}