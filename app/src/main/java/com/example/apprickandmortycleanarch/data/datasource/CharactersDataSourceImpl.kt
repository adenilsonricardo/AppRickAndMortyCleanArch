package com.example.apprickandmortycleanarch.data.datasource

import com.example.apprickandmortycleanarch.data.api.CharactersApi
import com.example.apprickandmortycleanarch.data.models.CharacterResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharactersDataSourceImpl(private val service: CharactersApi): CharacterDataSource {

    override fun getCharacter(): Flow<CharacterResponse> {
        return flow {
            emit(service.getCharacters())
        }
    }
}