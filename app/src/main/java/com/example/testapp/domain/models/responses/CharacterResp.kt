package com.example.testapp.domain.models.responses

import com.example.testapp.data.models.CharacterDto
import com.example.testapp.data.models.Info
import com.google.gson.annotations.SerializedName

data class CharacterResp(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<CharacterDto> = emptyList())