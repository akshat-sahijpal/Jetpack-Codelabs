package com.akshat.sahijpal.composeui.ui.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainCalculatorModule() {
    val vm = viewModel<CalculatorStateViewModel>()
    CalculatorLayoutMain(state = vm.state, modifier = Modifier.background(Color.DarkGray), onAction = vm::onAction)
}