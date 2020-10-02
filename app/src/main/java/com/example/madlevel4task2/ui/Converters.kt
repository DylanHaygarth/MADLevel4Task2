package com.example.madlevel4task2.ui

import androidx.room.TypeConverter
import com.example.madlevel4task2.model.Moves
import com.example.madlevel4task2.model.Results
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun fromMove(value: String?): Moves? {
        return value?.let { Moves.valueOf(it) }
    }

    @TypeConverter
    fun moveToString(Moves: Moves?): String? {
        return Moves?.toString()
    }

    @TypeConverter
    fun fromResult(value: String?): Results? {
        return value?.let { Results.valueOf(it) }
    }

    @TypeConverter
    fun resultToString(results: Results?): String? {
        return results?.toString()
    }
}