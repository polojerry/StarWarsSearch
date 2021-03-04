package com.polotech.starwars.data.localsource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polotech.starwars.data.localsource.models.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(characterEntity: CharacterEntity)

    @Query("SELECT * FROM table_favourite")
    suspend fun getFavourites() : List<CharacterEntity>
}