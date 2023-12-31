package com.example.testapp.ui.details

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testapp.ui.details.compontents.DetailsContent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailsScreen(
    id:Int,
    image: String,
    title: String,
    status:String,
    species: String,
    gender: String,
    origin: String,
    location:String,
    navigator: DestinationsNavigator,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val detailsState = viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.onGetCharacterEvent(id)
    }

    if (detailsState.value.isLoading) {
        CircularProgressIndicator()
    } else {
        DetailsContent(
            navigator = navigator,
            imageUrl = image,
            title = title,
            status = status,
            species = species,
            gender = gender,
            origin = origin,
            location = location)
    }
}