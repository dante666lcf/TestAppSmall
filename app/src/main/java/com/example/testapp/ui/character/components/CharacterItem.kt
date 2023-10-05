package com.example.testapp.ui.character.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.testapp.data.models.CharacterDto

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterItem(
    modifier: Modifier,
    imageUrl: String,
    text: String,
    characters: CharacterDto
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            model = imageUrl, contentDescription = null
        )

        Column {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(4.dp))
            CharacterStatusItem(characters = characters)
        }
    }
}

