package com.example.testapp.ui.details

import com.example.testapp.data.models.CharacterDto

data class DetailsState(
    var isLoading: Boolean = false,
    val characters: CharacterDto? = null,
    val error: String = ""
)