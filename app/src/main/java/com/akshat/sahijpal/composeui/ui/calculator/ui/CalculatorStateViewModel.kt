package com.akshat.sahijpal.composeui.ui.calculator.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.akshat.sahijpal.composeui.ui.calculator.util.CalculatorEventHandling
import com.akshat.sahijpal.composeui.ui.calculator.util.CalculatorState
import com.akshat.sahijpal.composeui.ui.calculator.util.Operations

class CalculatorStateViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(event: CalculatorEventHandling) {
        when (event) {
            is CalculatorEventHandling.Number -> enterNumber(event.symbols)
            is CalculatorEventHandling.Clear -> CalculatorState()
            is CalculatorEventHandling.Decimal -> enterDecimal()
            is CalculatorEventHandling.operations -> enterOperation(event.operation)
            is CalculatorEventHandling.Calculate -> evaluate()
            is CalculatorEventHandling.Delete -> deleteAll()
        }

    }

    private fun deleteAll() {
        when {
            state.num2.isNotBlank() -> state = state.copy(num2 = state.num2.dropLast(1))
            state.num1.isNotBlank() -> state = state.copy(num1 = state.num1.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
        }
    }

    private fun evaluate() {
        val num1 = state.num1.toDoubleOrNull()
        val num2 = state.num2.toDoubleOrNull()
        if (num1 != null && num2 != null) {
            val result = when (state.operation) {
                is Operations.add -> num1 + num2
                is Operations.multiply -> num1 * num2
                is Operations.divide -> num1 / num2
                is Operations.sub -> num1 - num2
                else -> return
            }
            state=state.copy(num1 = result.toString().take(12))
        }else return
    }

    private fun enterOperation(operation: Operations) {
        if (state.num1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.num1.contains(".") && state.num1.isNotBlank()) {
            state = state.copy(num1 = state.num1 + ".")
            return
        }
        if (state.operation == null && !state.num2.contains(".") && state.num2.isNotBlank()) {
            state = state.copy(num2 = state.num2 + ".")
            return
        }
    }

    private fun enterNumber(symbols: Int) {
        when {
            state.operation == null -> {
                if (state.num1.length >= 8) return
                state = state.copy(num1 = state.num1 + symbols)
                return
            }
            state.operation != null -> {
                if (state.num2.length >= 8) return
                state = state.copy(num2 = state.num2 + symbols)
            }
        }
    }
}