package com.polotech.starwars.data.remote.models.response

import com.polotech.starwars.data.remote.models.CharacterNetwork

data class SearchResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<CharacterNetwork>

)