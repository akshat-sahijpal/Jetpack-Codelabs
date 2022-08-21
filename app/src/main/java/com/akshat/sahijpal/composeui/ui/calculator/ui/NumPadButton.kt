package com.akshat.sahijpal.composeui.ui.calculator.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
 import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
 import androidx.compose.ui.unit.sp

@Composable
fun NumPadButton(
    symbol: String,
    modifier: Modifier,
    callback: () -> Unit
) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable {
                callback()
            }
            .then(modifier)
    ) {
        Text(text = symbol,
        style = TextStyle(fontSize = 36.sp, color = Color.Black),
        )
    }
}