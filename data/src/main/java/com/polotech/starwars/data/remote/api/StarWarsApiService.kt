package com.polotech.starwars.data.remote.api

import com.polotech.starwars.data.remote.models.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApiService {

    @GET("people/")
    suspend fun searchCharacter(@Query("search") name: String): SearchResponse


}