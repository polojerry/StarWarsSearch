package com.polotech.starwars.data.remote.models

import com.squareup.moshi.Json

data class FilmNetwork(
    val title: String,

    @Json(name = "opening_crawl")
    val openingCrawl: String
)