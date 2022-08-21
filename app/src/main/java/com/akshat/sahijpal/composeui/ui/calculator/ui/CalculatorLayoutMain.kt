package com.akshat.sahijpal.composeui.ui.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshat.sahijpal.composeui.ui.calculator.util.CalculatorEventHandling
import com.akshat.sahijpal.composeui.ui.calculator.util.CalculatorState
import com.akshat.sahijpal.composeui.ui.calculator.util.Operations

@Composable
fun CalculatorLayoutMain(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorEventHandling) -> Unit
) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter), verticalArrangement = Arrangement.spacedBy(buttonSpacing)) {
            Text(text = with(state) { num1 + (operation ?: "") + num2 }, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp), style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold, color = Color.White), maxLines = 1)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumPadButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    callback = { onAction(CalculatorEventHandling.Clear) })
                NumPadButton(
                    symbol = "del",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Delete) })
                NumPadButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.operations(operation = Operations.divide)) })
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumPadButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 7)) })
                NumPadButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 8)) })
                NumPadButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 9)) })
                NumPadButton(
                    symbol = "*",
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.operations(operation = Operations.multiply)) })
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumPadButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 4)) })
                NumPadButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 5)) })
                NumPadButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 6)) })
                NumPadButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.operations(operation = Operations.sub)) })
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumPadButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 1)) })
                NumPadButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 2)) })
                NumPadButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 3)) })
                NumPadButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.operations(operation = Operations.add)) })
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumPadButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    callback = { onAction(CalculatorEventHandling.Number(symbols = 0)) })
                NumPadButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Decimal) })
                NumPadButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(color = Color.Yellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    callback = { onAction(CalculatorEventHandling.Calculate) })
            }
        }
    }
}