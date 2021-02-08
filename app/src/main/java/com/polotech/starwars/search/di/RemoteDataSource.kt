package com.polotech.starwars.search.di

import com.polotech.starwars.data.remote.api.StarWarsApiService
import com.polotech.starwars.data.remote.repositories.CharacterDetailsRepositoryImpl
import com.polotech.starwars.data.remote.repositories.SearchCharacterRepositoryImpl
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RemoteDataSource {

    @Provides
    fun providesRemoteRepository(starWarsApi: StarWarsApiService): SearchCharacterRepository {
        return SearchCharacterRepositoryImpl(starWarsApi)
    }

    @Provides
    fun providesRemoteDetailsRepository(starWarsApi: StarWarsApiService) : CharacterDetailsRepository{
        return CharacterDetailsRepositoryImpl(starWarsApi)
    }
}