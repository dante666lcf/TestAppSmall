package com.example.testapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.testapp.Resource
import com.example.testapp.data.api.Api
import com.example.testapp.data.models.CharacterDto
import com.example.testapp.data.paging.CharacterMediator
import com.example.testapp.data.room.AppDatabase
import com.example.testapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class CharacterRepositoryImp @Inject constructor(
    private val api: Api,
    private val database: AppDatabase,
) : CharacterRepository {
    private val dao = database.characterDao()
    override fun getCharacters(): Flow<PagingData<CharacterDto>> {
        val pagingSourceFactory = { dao.getCharacters() }
        return Pager(
            config = PagingConfig(pageSize = 30),
            remoteMediator = CharacterMediator(
                api = api,
                database = database
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override suspend fun getSelectedCharacter(id: Int): Resource<CharacterDto> {
        val response = try {
            api.getSingleCharacter(id)
        } catch (e: Exception) {
            return Resource.Error("Unknown Error")
        }
        return Resource.Success(response)
    }
}