package com.polotech.starwars.search.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterPresenter(
    val name: String,
    val heightInCm: String,
    val heightInFeet : String,
    val birthYear: String,
    val url: String,
) : Parcelable