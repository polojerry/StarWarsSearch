package com.polotech.starwars.core.di

import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import com.polotech.starwars.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {


    @SearchUseCase
    @Provides
    fun providesSearchCharacterUseCase(searchCharacterRepository: SearchCharacterRepository): SearchCharacterUseCase {
        return SearchCharacterUseCase(searchCharacterRepository)
    }

    @CharacterDetailsUseCase
    @Provides
    fun providesCharacterWithDetailsUseCase(characterDetailsRepository: CharacterDetailsRepository): FetchCharacterWithDetailsUseCase {
        return FetchCharacterWithDetailsUseCase(characterDetailsRepository)
    }

    @FilmUseCase
    @Provides
    fun providesFilmUseCase(characterDetailsRepository: CharacterDetailsRepository): FetchFilmUseCase {
        return FetchFilmUseCase(characterDetailsRepository)
    }

    @PlanetUseCase
    @Provides
    fun providesPlanetUseCase(characterDetailsRepository: CharacterDetailsRepository): FetchPlanetUseCase {
        return FetchPlanetUseCase(characterDetailsRepository)
    }

    @SpeciesUseCase
    @Provides
    fun providesSpeciesUseCase(characterDetailsRepository: CharacterDetailsRepository): FetchSpeciesUseCase {
        return FetchSpeciesUseCase(characterDetailsRepository)
    }


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class CharacterDetailsUseCase

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class FilmUseCase

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class PlanetUseCase

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SpeciesUseCase

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SearchUseCase




}