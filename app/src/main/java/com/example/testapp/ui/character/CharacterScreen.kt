package com.example.testapp.ui.character

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.testapp.ui.character.components.CharacterItem
import com.example.testapp.ui.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Destination(start = true)
fun CharacterScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state = viewModel.characterListState.value
    val characters = state.characters.collectAsLazyPagingItems()

    Scaffold(
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(characters) { character ->
                    CharacterItem(
                        modifier = Modifier
                            .height(160.dp)
                            .clickable {
                                navigator.navigate(
                                    DetailsScreenDestination(
                                        id = character?.id!!,
                                        image = character.image,
                                        title = character.name,
                                        status = character.status,
                                        species = character.species,
                                        gender = character.gender,
                                        origin = character.origin!!.name,
                                        location = character.location!!.name,
                                    )
                                )
                            },
                        imageUrl = character!!.image,
                        text = character.name,
                        characters = character
                    )
                }
            }
        }
    )
}