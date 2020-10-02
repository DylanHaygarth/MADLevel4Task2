package com.example.madlevel4task2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.madlevel4task2.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM gamesTable")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Query("DELETE FROM gamesTable")
    suspend fun deleteAllGames()

    @Query("SELECT COUNT(results) FROM gamesTable WHERE results = 'WIN'")
    suspend fun getWins(): Int

    @Query("SELECT COUNT(results) FROM gamesTable WHERE results = 'LOSE'")
    suspend fun getLosses(): Int

    @Query("SELECT COUNT(results) FROM gamesTable WHERE results = 'DRAW'")
    suspend fun getDraws(): Int
}