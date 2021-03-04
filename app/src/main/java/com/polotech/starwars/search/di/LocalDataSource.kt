package com.polotech.starwars.search.di

import android.content.Context
import androidx.room.Room
import com.polotech.starwars.data.localsource.database.FavouriteDao
import com.polotech.starwars.data.localsource.database.StarWarsSearchDatabase
import com.polotech.starwars.data.localsource.repository.FavouriteRepositoryImp
import com.polotech.starwars.domain.repository.FavouriteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object LocalDataSource {

    @Provides
    fun providesStarWarsSearchDatabase(@ApplicationContext context: Context): StarWarsSearchDatabase {
        return Room.databaseBuilder(
            context,
            StarWarsSearchDatabase::class.java,
            STAR_WARS_SEARCH_DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesFavouriteDao (starWarsSearchDatabase: StarWarsSearchDatabase) : FavouriteDao{
        return starWarsSearchDatabase.favouriteDao
    }

    @Provides
    fun providesFavouriteRepository(favouriteDao: FavouriteDao) : FavouriteRepository{
        return FavouriteRepositoryImp(favouriteDao)
    }

    private const val STAR_WARS_SEARCH_DATABASE_NAME = "star_wars_search_database.db"
}