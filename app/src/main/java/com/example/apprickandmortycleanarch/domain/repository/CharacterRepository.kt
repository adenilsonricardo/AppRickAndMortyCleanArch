package com.example.apprickandmortycleanarch.domain.repository

import com.example.apprickandmortycleanarch.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacter(): Flow<Characters>
}