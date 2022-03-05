package com.example.apprickandmortycleanarch.data.datasource

import com.example.apprickandmortycleanarch.data.models.CharacterResponse
import kotlinx.coroutines.flow.Flow

internal interface CharacterDataSource {
    fun getCharacter(): Flow<CharacterResponse>
}