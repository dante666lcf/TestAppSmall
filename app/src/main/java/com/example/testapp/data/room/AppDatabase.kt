package com.example.testapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testapp.data.models.CharacterDto
import com.example.testapp.domain.models.CharacterRemoteKeys

@Database(
    entities = [CharacterDto::class, CharacterRemoteKeys::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocationConverter::class, OriginConverter::class, ListConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun characterRemoteDao(): CharacterRemoteDao
}