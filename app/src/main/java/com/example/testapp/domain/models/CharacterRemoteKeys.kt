package com.example.testapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testapp.Constans.CHARACTER_REMOTE_KEYS_DATABASE_TABLE

@Entity(tableName = CHARACTER_REMOTE_KEYS_DATABASE_TABLE)
data class CharacterRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)