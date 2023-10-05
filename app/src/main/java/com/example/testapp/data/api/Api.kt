package com.example.testapp.data.api

import com.example.testapp.data.models.CharacterDto
import com.example.testapp.domain.models.responses.CharacterResp
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int = 0
    ): CharacterResp

    @GET("character/{id}")
    suspend fun getSingleCharacter(id: Int): CharacterDto
}
