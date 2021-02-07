package com.polotech.starwars.search.di

import com.polotech.starwars.domain.repository.SearchCharacterRepository
import com.polotech.starwars.domain.usecases.SearchCharacterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {

    @Provides
    @SearchUseCase
    fun providesSearchCharacterUseCase(searchCharacterRepository: SearchCharacterRepository): SearchCharacterUseCase {
        return SearchCharacterUseCase(searchCharacterRepository)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SearchUseCase
}