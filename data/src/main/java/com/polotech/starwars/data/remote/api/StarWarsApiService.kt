package com.polotech.starwars.data.remote.api

import com.polotech.starwars.data.remote.models.CharacterWithDetailsNetwork
import com.polotech.starwars.data.remote.models.FilmNetwork
import com.polotech.starwars.data.remote.models.PlanetNetwork
import com.polotech.starwars.data.remote.models.SpeciesNetwork
import com.polotech.starwars.data.remote.models.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface StarWarsApiService {

    @GET("people/")
    suspend fun searchCharacter(@Query("search") name: String): SearchResponse

    @GET
    suspend fun fetchCharacterDetails(@Url characterUrl: String): CharacterWithDetailsNetwork

    @GET
    suspend fun fetchPlanet(@Url planetUrl: String): PlanetNetwork

    @GET
    suspend fun fetchSpecie(@Url speciesUrl: String): SpeciesNetwork

    @GET
    suspend fun fetchFilm(@Url filmsUrl: String): FilmNetwork


}