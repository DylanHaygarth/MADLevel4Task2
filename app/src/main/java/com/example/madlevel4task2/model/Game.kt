package com.example.madlevel4task2.model

import java.util.*

enum class Moves {
    ROCK,
    PAPER,
    SCISSORS
}

enum class Results {
    WIN,
    LOSE,
    DRAW
}

data class Game (
    var result: Results,
    var playerMoves: Moves,
    var computerMoves: Moves,
    var date: Date
)