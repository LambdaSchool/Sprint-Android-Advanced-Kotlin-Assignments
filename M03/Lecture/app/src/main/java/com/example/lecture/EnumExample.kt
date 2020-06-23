package com.example.lecture

enum class Numbers {
    one,
    two,
    three
}
fun enumDemo(num: Numbers) {
   /* when(num) {
        Numbers.one -> TODO()
        Numbers.two -> TODO()
        Numbers.three -> TODO()
    }*/

    println(Numbers.one.name) // Gets Enum Value as String
    print(Numbers.one.ordinal) //Gets index
}