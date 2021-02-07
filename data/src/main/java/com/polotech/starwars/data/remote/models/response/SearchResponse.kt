package com.polotech.starwars.data.remote.models.response

import com.squareup.moshi.Json

data class SearchResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<CharacterNetwork>

)