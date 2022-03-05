package com.example.apprickandmortycleanarch.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.apprickandmortycleanarch.data.api.CharactersApi
import com.example.apprickandmortycleanarch.data.datasource.CharacterDataSource
import com.example.apprickandmortycleanarch.data.datasource.CharactersDataSourceImpl
import com.example.apprickandmortycleanarch.data.mapper.CharacterMapper
import com.example.apprickandmortycleanarch.data.repository.CharacterRepositoryImpl
import com.example.apprickandmortycleanarch.data.service.RetrofitService
import com.example.apprickandmortycleanarch.domain.repository.CharacterRepository
import com.example.apprickandmortycleanarch.domain.usecase.CharactersUseCase
import com.example.apprickandmortycleanarch.presentation.viewModel.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class CharacterModule: FeatureModule() {
    @RequiresApi(Build.VERSION_CODES.N)
    override val dataModule = module {
        factory<CharacterDataSource> { CharactersDataSourceImpl(service = get()) }
        factory<CharacterRepository> { CharacterRepositoryImpl(characterDataSource = get(), characterMapper = get()) }
        factory<CharactersApi> { RetrofitService.service}
        factory<CharacterMapper> {CharacterMapper()}
    }
    override val domainModule = module {
        factory { CharactersUseCase(repository = get()) }
    }
    override val presentationModule =
        module { viewModel { CharactersViewModel(charactersUseCase = get()) } }

}