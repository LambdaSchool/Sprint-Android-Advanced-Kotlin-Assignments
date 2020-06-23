package com.example.lecture

fun main(args: Array<String>) {
    setGetField()
}

private val values = IntArray(5) {it*1}
private val valuesSum: Int
    get() {
        return values.sum()
    }
fun setGetField() {
    println(valuesSum)
    println(valuesSum)
}