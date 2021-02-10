package com.polotech.starwars.domain.models

data class CharacterWithDetailsModel(
    val name: String,
    val height: String,
    val birthYear: String,
    val url: String,
    val filmUrls: List<String>,
    val planetUrl: String,
    val speciesUrls: List<String>,
)