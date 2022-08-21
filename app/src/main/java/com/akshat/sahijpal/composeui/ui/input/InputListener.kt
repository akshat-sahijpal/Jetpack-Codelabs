package com.akshat.sahijpal.composeui.ui.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun InputListener() {
      var text by remember { mutableStateOf("name") }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(all = 30.dp)
                .clip(RectangleShape)
                .background(Color(0xFF3396c)),
            contentAlignment = Alignment.TopCenter
        ){

        }
}