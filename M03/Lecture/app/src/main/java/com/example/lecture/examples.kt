package com.example.lecture

//lateinit must have value
lateinit var demoValue: String
var varHasToBeInitialized: String? = null

fun main(args: Array<String>) {
    //lateinitDemo()
    lazyDemo()
}
fun lateinitDemo() {
    // lateinit value has to be initialized
    demoValue = "Hello lateinit"
    println(demoValue)
}

var intRand: Int = 0
val lazyString by lazy {
    println("Initializing lazyString")
    "lazy string"
    for (i in 1.. intRand) {

    }
}
fun lazyDemo() {
    println("Booty - Butt - Cheeks")
    println(lazyString)
    println(lazyString)
}