package com.example.apprickandmortycleanarch.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprickandmortycleanarch.domain.model.Characters
import com.example.apprickandmortycleanarch.domain.usecase.CharactersUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

internal class CharactersViewModel(
    private val charactersUseCase: CharactersUseCase,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _characters: MutableLiveData<Characters> = MutableLiveData()
    val characters: LiveData<Characters> = _characters
    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    init {
        getCharacters()
    }

    private fun getCharacters(){
        viewModelScope.launch {
            charactersUseCase()
                .flowOn(coroutineDispatcher)
                .catch { exception ->
                    _error.value = exception.message
                }
                .collect { charactersList ->
                    _characters.value = charactersList
                }
        }
    }
}