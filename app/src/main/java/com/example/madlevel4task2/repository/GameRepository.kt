package com.example.madlevel4task2.repository

import android.content.Context
import com.example.madlevel4task2.dao.GameDao
import com.example.madlevel4task2.database.GameDatabase
import com.example.madlevel4task2.model.Game

class ProductRepository(context: Context) {
    private val gameDao: GameDao

    init {
        val database =
            GameDatabase.getDatabase(
                context
            )
        gameDao = database!!.gameDao()
    }

    suspend fun getAllProducts(): List<Game> = gameDao.getAllGames()

    suspend fun insertProduct(game: Game) = gameDao.insertGame(game)

    suspend fun deleteProduct(game: Game) = gameDao.deleteGame(game)

    suspend fun deleteAllProducts() = gameDao.deleteAllGames()

}