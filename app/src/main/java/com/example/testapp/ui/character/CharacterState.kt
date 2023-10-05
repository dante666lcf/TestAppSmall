package com.example.testapp.ui.character

import androidx.paging.PagingData
import com.example.testapp.data.models.CharacterDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharacterState(
    var isLoading: Boolean = false,
    val characters: Flow<PagingData<CharacterDto>> = emptyFlow(),
    val error: String = ""
)