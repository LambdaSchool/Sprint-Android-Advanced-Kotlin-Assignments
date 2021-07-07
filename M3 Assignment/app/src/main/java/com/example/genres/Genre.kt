package com.example.genres

sealed class Genre(val name: String)

class HipHop(name: String):Genre(name)

class Rock(name: String):Genre(name)

class Techno(name: String):Genre(name)