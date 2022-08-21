package com.akshat.sahijpal.composeui.ui.listing

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshat.sahijpal.composeui.Message
import com.akshat.sahijpal.composeui.SampleData


@Composable
fun ListOfDetailedScreen(id: Int) {
    LazyColumn {
        items(items = SampleData.conversationSample) {
            detailScreen(user = it, id)
        }
    }
}
@Composable
fun detailScreen(user: Message, id: Int) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    var transitionAnim by rememberSaveable { mutableStateOf(true) }
    var color by rememberSaveable { mutableStateOf(Color.White) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isExpanded) {
                    color = Color.Yellow
                    color
                } else {
                    color = Color.White
                    color
                }
            )
            .padding(start = 20.dp, top = 40.dp)
    ) {
        val current = LocalDensity.current
        AnimatedVisibility(
            visible = transitionAnim,
            enter = slideInVertically { with(current) { -40.dp.roundToPx() } } + expandVertically(expandFrom = Alignment.Top) + fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        )  {
            Image(
                painter = painterResource(id = id),
                contentDescription = "lem",
                modifier = Modifier
                    .size(50.dp)
                    .clip(
                        CircleShape
                    )
                    .border(width = 1.dp, color = Color.Green, shape = CircleShape),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = user.title,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 13.sp,
                    fontFamily = FontFamily.Monospace
                )
            )
            val visible by remember { mutableStateOf(true) }
            Spacer(modifier = Modifier.height(2.dp))
            AnimatedVisibility(visible = visible,
                enter = slideInVertically {
                    with(current) {
                        -30.dp.roundToPx()
                    }
                }) {
                Text(
                    text = user.body,
                    style = TextStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    ), maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}