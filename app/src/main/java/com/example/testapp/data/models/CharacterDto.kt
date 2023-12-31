package com.example.testapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testapp.Constans.CHARACTER_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = CHARACTER_TABLE)
data class CharacterDto(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: Origin? = null,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)