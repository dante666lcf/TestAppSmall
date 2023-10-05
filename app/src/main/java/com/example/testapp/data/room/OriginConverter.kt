package com.example.testapp.data.room

import androidx.room.TypeConverter
import com.example.testapp.data.models.Origin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object OriginConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromOrigin(origin: Origin): String {
        return gson.toJson(
            origin,
            object : TypeToken<Origin>() {}.type
        )
    }

    @TypeConverter
    fun toOriginJson(json: String): Origin {
        return gson.fromJson(
            json,
            object : TypeToken<Origin>() {}.type
        )
    }
}