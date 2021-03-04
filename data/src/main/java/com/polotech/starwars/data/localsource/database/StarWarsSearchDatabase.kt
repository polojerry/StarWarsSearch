package com.polotech.starwars.data.localsource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.polotech.starwars.data.localsource.models.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 1, exportSchema= false)
abstract class StarWarsSearchDatabase  : RoomDatabase(){
    abstract val favouriteDao : FavouriteDao
}
