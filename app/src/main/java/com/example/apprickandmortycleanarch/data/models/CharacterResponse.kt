package com.example.apprickandmortycleanarch.data.models

import com.example.apprickandmortycleanarch.domain.model.Info
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("info")
    val info: Info = Info(),
    @SerialName("results")
    val results:List<ResultsResponse>
)