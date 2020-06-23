package com.example.lecture

sealed class Expr // can't inherit or access class out side of inner class
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

data class sealedExt(val string: String) : Expr()

fun eval(expr: Expr) : Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    is sealedExt -> expr.string.length.toDouble()
}
// Use Cases -- set list of messages that I can accept
// Kind of like an enum for classes
// Higher order function accepts functions as a parameter