package com.example.testapp.ui.character.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.data.models.CharacterDto

@Composable
fun CharacterStatusItem(
    characters: CharacterDto
) {
    Row(
        modifier = Modifier
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = when (characters.status) {
                "Alive" -> {
                    stringResource(R.string.alive)
                }

                "Dead" -> {
                    stringResource(R.string.dead)
                }

                else -> {
                    stringResource(R.string.unknown)
                }
            },
            style = MaterialTheme.typography.subtitle1,
            color = when (characters.status) {
                "Alive" -> {
                    Color.Green
                }

                "Dead" -> {
                    Color.Red
                }

                else -> {
                    Color.Gray
                }
            }
        )
    }
}