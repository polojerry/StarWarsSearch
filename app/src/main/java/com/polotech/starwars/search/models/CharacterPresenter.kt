package com.polotech.starwars.search.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterPresenter(
    val name: String,
    val heightInCm: String,
    val heightInFeet : String,
    val birthYear: String,
    val url: String,
) : Parcelable