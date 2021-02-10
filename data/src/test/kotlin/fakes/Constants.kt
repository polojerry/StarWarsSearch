package fakes

object Constants {

    val CHARACTER_NAME = "Yoda"
    val CHARACTER_NAME_WITH_NO_SPECIE = "Boba"

    object URLS {
        val CHARACTER_SEARCH_URL = "/api/people/?search=${CHARACTER_NAME}"
        val CHARACTER_URL = "/api/people/20/"
        val CHARACTER_URL_WITH_NO_SPECIE = "/api/people/22/"
        val FILM_URL = "/api/films/2/"
        val SPECIE_URL = "/api/species/6/"
        val EMPTY_SPECIE_URL = ""
        val PLANET_URL = "/api/planets/28/"
    }

}