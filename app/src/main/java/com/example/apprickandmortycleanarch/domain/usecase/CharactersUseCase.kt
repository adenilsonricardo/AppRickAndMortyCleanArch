package com.example.apprickandmortycleanarch.domain.usecase

import com.example.apprickandmortycleanarch.domain.model.Characters
import com.example.apprickandmortycleanarch.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharactersUseCase(
    private val repository: CharacterRepository,
) {
    operator fun invoke(): Flow<Characters> {
        return repository.getCharacter()
    }
}