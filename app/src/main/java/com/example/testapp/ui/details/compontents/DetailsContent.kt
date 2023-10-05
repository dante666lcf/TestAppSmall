package com.example.testapp.ui.details.compontents

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.testapp.R
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsContent(
    navigator: DestinationsNavigator,
    imageUrl: String,
    title: String,
    status: String,
    species: String,
    gender: String,
    origin: String,
    location: String,

    ) {
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                IconButton(
                    modifier = Modifier.size(60.dp),
                    onClick = {
                        navigator.popBackStack()
                    }) {
                    Icon(
                        tint = Color.Black,
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(
                            id = R.string.arrow_back
                        )
                    )
                }
                Row {
                    GlideImage(
                        model = imageUrl, contentDescription = null
                    )
                    Column {
                        Text(
                            modifier = Modifier
                                .padding(start = 40.dp),
                            text = title,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h6,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .padding(start = 40.dp, top = 8.dp)
                                .clip(shape = RoundedCornerShape(8.dp)),
                        ) {
                            Column {
                                DetailItem(
                                    name = stringResource(id = R.string.status),
                                    item = status
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                DetailItem(
                                    name = stringResource(id = R.string.species),
                                    item = species
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                DetailItem(
                                    name = stringResource(id = R.string.gender),
                                    item = gender
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                DetailItem(
                                    name = stringResource(id = R.string.origin),
                                    item = origin
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                DetailItem(
                                    name = stringResource(id = R.string.location),
                                    item = location
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}