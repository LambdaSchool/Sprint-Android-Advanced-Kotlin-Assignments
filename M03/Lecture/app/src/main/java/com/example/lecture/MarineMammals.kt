package com.example.lecture

// the
sealed class MarineMammal(val name: String)

class Whale(name: String) : MarineMammal(name)
class Dolphin(name: String): MarineMammal(name)
class Otter(name: String): MarineMammal(name)