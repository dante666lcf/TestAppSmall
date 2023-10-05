package com.example.testapp.domain.use_cases

import androidx.paging.PagingData
import com.example.testapp.data.models.CharacterDto
import com.example.testapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<PagingData<CharacterDto>> {
        return repository.getCharacters()
    }
}