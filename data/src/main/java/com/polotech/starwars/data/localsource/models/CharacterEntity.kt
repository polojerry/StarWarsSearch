package com.polotech.starwars.data.localsource.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_favourite")
data class CharacterEntity(
        val name : String,
        val height : String,

        @ColumnInfo(name = "birth_year")
        val birthYear : String,

        @PrimaryKey
        val url :String,
)