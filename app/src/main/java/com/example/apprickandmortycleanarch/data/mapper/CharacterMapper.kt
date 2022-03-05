package com.example.apprickandmortycleanarch.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.apprickandmortycleanarch.data.models.CharacterResponse
import com.example.apprickandmortycleanarch.data.models.Location
import com.example.apprickandmortycleanarch.data.models.ResultsResponse
import com.example.apprickandmortycleanarch.domain.model.Characters
import com.example.apprickandmortycleanarch.domain.model.CharactersResult
import com.example.apprickandmortycleanarch.domain.model.Info
import com.example.apprickandmortycleanarch.domain.model.Origin
import com.example.apprickandmortycleanarch.utils.Mapper

@RequiresApi(Build.VERSION_CODES.N)
class CharacterMapper: Mapper<CharacterResponse, Characters> {

    override fun map(source: CharacterResponse): Characters {
        return Characters(
            info = Info(),
            results = mapResults(source.results),
        )
    }
    private fun mapResults(statusResult: List<ResultsResponse>): List<CharactersResult> {
        return statusResult.map {
            CharactersResult(
                created = it.created,
                episode = it.episode,
                gender = it.gender,
                id = it.id,
                image = it.image,
                name = it.name,
                species = it.species,
                status = it.status,
                type = it.type,
                url = it.url,
                location = Location(
                    name = "",
                    url = ""
                ),
                origin = Origin(name = "", url = "")
            )
        }
    }
}