package com.example.apprickandmortycleanarch.domain.model

data class Characters(
    val info: com.example.apprickandmortycleanarch.domain.model.Info = Info(),
    val results: List<CharactersResult>
)