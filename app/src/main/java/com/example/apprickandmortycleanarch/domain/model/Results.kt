package com.example.apprickandmortycleanarch.domain.model

import com.example.apprickandmortycleanarch.data.models.Location

data class Info(
    val count: Int = 0,
    val next: String = "",
    val pages: Int = 0,
    val prev: Any? = null
)

data class CharactersResult(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
data class Location(
    val name: String ,
    val url: String
)

data class Origin(
    val name: String ,
    val url: String
)