package com.polotech.starwars.feature.details.models

data class CharacterWithDetailsPresenter(
    val name: String,
    val height: String,
    val birthYear: String,
    val url: String,
    val filmUrls: List<String>,
    val planetUrl: String,
    val speciesUrls: List<String>,
)