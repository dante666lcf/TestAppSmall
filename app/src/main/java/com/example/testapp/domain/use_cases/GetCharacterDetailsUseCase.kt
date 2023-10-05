package com.example.testapp.domain.use_cases

import com.example.testapp.Resource
import com.example.testapp.data.models.CharacterDto
import com.example.testapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(id: Int): Flow<Resource<CharacterDto>> = flow {
        emit(Resource.Loading())
        when (val characterDetails = repository.getSelectedCharacter(id)) {
            is Resource.Success -> emit(characterDetails)
            else -> {
                emit(Resource.Error<CharacterDto>(data = null, message = "Error"))
            }
        }
    }
}