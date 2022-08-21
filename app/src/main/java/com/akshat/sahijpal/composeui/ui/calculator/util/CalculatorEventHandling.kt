package com.akshat.sahijpal.composeui.ui.calculator.util

sealed class CalculatorEventHandling{
    data class Number(var symbols: Int): CalculatorEventHandling()
    object Clear: CalculatorEventHandling()
    object Delete: CalculatorEventHandling()
    object Decimal: CalculatorEventHandling()
    object Calculate: CalculatorEventHandling()
    data class operations(var operation: Operations) : CalculatorEventHandling()
}

sealed class Operations(var operator:String){
    object add : Operations("+")
    object sub : Operations("-")
    object multiply : Operations("*")
    object divide : Operations("/")
}

data class CalculatorState(
    var num1: String="",
    var num2: String="",
    var operation: Operations?=null
)