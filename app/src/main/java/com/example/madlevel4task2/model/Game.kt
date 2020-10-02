package com.example.madlevel4task2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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

@Entity(tableName = "gamesTable")
data class Game (
    @ColumnInfo(name = "results")
    var result: Results,

    @ColumnInfo(name = "playerMoves")
    var playerMoves: Moves,

    @ColumnInfo(name = "computerMoves")
    var computerMoves: Moves,

    @ColumnInfo(name = "date")
    var date: Date,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)
