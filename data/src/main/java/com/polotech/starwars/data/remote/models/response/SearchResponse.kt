package com.polotech.starwars.data.remote.models.response

import com.squareup.moshi.Json

data class SearchResponse(
    val name: String,
    val height: String,

    @Json(name = "birth_year")
    val birth_year: String,
    val url: String,
)