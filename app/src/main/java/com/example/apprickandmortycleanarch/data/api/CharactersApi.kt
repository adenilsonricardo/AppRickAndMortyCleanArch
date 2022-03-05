package com.example.apprickandmortycleanarch.data.api

import com.example.apprickandmortycleanarch.data.models.CharacterResponse
import retrofit2.http.GET

interface CharactersApi {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}