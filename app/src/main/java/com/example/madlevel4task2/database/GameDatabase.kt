package com.example.madlevel4task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.madlevel4task2.dao.GameDao
import com.example.madlevel4task2.model.Game
import com.example.madlevel4task2.ui.Converters

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "GAMES_DATABASE"

        @Volatile
        private var gamesRoomDatabaseInstance: GameDatabase? = null

        fun getDatabase(context: Context): GameDatabase? {
            if (gamesRoomDatabaseInstance == null) {
                synchronized(GameDatabase::class.java) {
                    if (gamesRoomDatabaseInstance == null) {
                        gamesRoomDatabaseInstance =
                            Room.databaseBuilder(context.applicationContext,
                                GameDatabase::class.java,
                                DATABASE_NAME
                            ).build()
                    }
                }
            }
            return gamesRoomDatabaseInstance
        }
    }
}