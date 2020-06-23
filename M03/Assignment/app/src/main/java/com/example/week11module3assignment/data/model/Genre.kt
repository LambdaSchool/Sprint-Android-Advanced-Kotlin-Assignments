package com.example.week11module3assignment.data.model

sealed class Genre() {

    open lateinit var description: String
    open lateinit var name: String

    class Rap : Genre()

    class Pop : Genre()

    class Rock : Genre()

    class RAndB : Genre()
}
