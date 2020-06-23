package com.example.lecture

import kotlin.properties.Delegates

fun main(args: Array<String>) {
    vetoableDemo()
}
//notNull -- similar to lateinit, crashes if no value assigned
var max: Int by Delegates.notNull()

fun notNullDemo() {
    //println(max) // Won't work -- will crash
    max = 10
    println(max)
}

//observable -- register a callback when the value changes
var observed = false
var max2: Int by Delegates.observable(0) { property, oldValue, newValue ->
    observed = true
}

fun observableDemo() {
    println(max2)
    println(observed.toString()) //false
    max2 = 32
    println(observed.toString())//true
}
//vetoable -- register a callback when the value changes
var max3: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    newValue > oldValue
}

fun vetoableDemo() {
    max3 = 1
    println(max3) // 1
    max3 = 10
    println(max3) // 10
    max3 = 4
    println(max3) //10

}