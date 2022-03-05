package com.example.apprickandmortycleanarch.data.respository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.apprickandmortycleanarch.data.datasource.CharacterDataSource
import com.example.apprickandmortycleanarch.data.mapper.CharacterMapper
import com.example.apprickandmortycleanarch.domain.model.Characters
import com.example.apprickandmortycleanarch.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class CharacterRepositoryImpl (
    private val characterDataSource: CharacterDataSource,
    private val characterMapper: CharacterMapper
): CharacterRepository {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun getCharacter(): Flow<Characters> {
        return characterDataSource.getCharacter().map (characterMapper::map)
    }
}