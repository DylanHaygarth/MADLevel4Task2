package com.example.madlevel4task2.dao

import androidx.room.*
import com.example.madlevel4task2.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM gamesTable")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM gamesTable")
    suspend fun deleteAllGames()
}