package com.example.testapp.domain.repository

import androidx.paging.PagingData
import com.example.testapp.Resource
import com.example.testapp.data.models.CharacterDto
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(): Flow<PagingData<CharacterDto>>

    suspend fun getSelectedCharacter(id: Int): Resource<CharacterDto>
}