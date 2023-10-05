package com.example.testapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testapp.domain.models.CharacterRemoteKeys

@Dao
interface CharacterRemoteDao {
    @Query("SELECT * FROM CHARACTER_REMOTE_KEYS_TABLE WHERE id =:heroId")
    suspend fun getRemoteKeys(heroId: Int): CharacterRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKey: List<CharacterRemoteKeys>)

    @Query("DELETE FROM CHARACTER_REMOTE_KEYS_TABLE")
    suspend fun deleteAllRemoteKeys()
}