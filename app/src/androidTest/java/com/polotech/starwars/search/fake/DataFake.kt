package com.polotech.starwars.search.fake

import com.polotech.starwars.domain.models.*
import com.polotech.starwars.search.models.CharacterPresenter
import com.polotech.starwars.search.models.FilmPresenter
import com.polotech.starwars.search.models.PlanetPresenter
import com.polotech.starwars.search.models.SpeciesPresenter

object DataFake {

    object height {
        val cm = "180"
        val feet = "5.91"
    }

    object population {
        val unknown = "unknown"
        val populationUnformated = "1000000"
        val populationFormatted = "1.000,000"
    }

    object characters {
        val characterModel = CharacterModel(
            "Yoda",
            "180",
            "896BBY",
            "http://swapi.dev/api/people/20/"
        )

        val characterPresenter = CharacterPresenter(
            "Yoda",
            "180",
            "5.91",
            "896BBY",
            "http://swapi.dev/api/people/20/"
        )
    }

    object charactersWithDetails {

        val character = CharacterWithDetailsModel(
            "Yoda",
            "66",
            "896BBY",
            "http://swapi.dev/api/people/20/",
            listOf(
                "http://swapi.dev/api/films/2/",
                "http://swapi.dev/api/films/3/",
                "http://swapi.dev/api/films/4/",
                "http://swapi.dev/api/films/5/",
                "http://swapi.dev/api/films/6/",
            ),
            "http://swapi.dev/api/planets/28/",
            listOf("http://swapi.dev/api/species/6/")
        )
    }

    object films {
        val filmModel = FilmModel(
            "The Empire Strikes Back",
            "It is a dark time for the\\r\\nRebellion. Although the Death\\r\\nStar has been destroyed,\\r\\nImperial troops have driven the\\r\\nRebel forces from their hidden\\r\\nbase and pursued them across\\r\\nthe galaxy.\\r\\n\\r\\nEvading the dreaded Imperial\\r\\nStarfleet, a group of freedom\\r\\nfighters led by Luke Skywalker\\r\\nhas established a new secret\\r\\nbase on the remote ice world\\r\\nof Hoth.\\r\\n\\r\\nThe evil lord Darth Vader,\\r\\nobsessed with finding young\\r\\nSkywalker, has dispatched\\r\\nthousands of remote probes into\\r\\nthe far reaches of space....\"",
        )

        val filmPresentation = FilmPresenter(
            "The Empire Strikes Back",
            "It is a dark time for the\\r\\nRebellion. Although the Death\\r\\nStar has been destroyed,\\r\\nImperial troops have driven the\\r\\nRebel forces from their hidden\\r\\nbase and pursued them across\\r\\nthe galaxy.\\r\\n\\r\\nEvading the dreaded Imperial\\r\\nStarfleet, a group of freedom\\r\\nfighters led by Luke Skywalker\\r\\nhas established a new secret\\r\\nbase on the remote ice world\\r\\nof Hoth.\\r\\n\\r\\nThe evil lord Darth Vader,\\r\\nobsessed with finding young\\r\\nSkywalker, has dispatched\\r\\nthousands of remote probes into\\r\\nthe far reaches of space....\"",
        )

    }

    object planet {
        val planetModel = PlanetModel(
            "unknown",
            "unknown",
        )

        val planetPresenter = PlanetPresenter(
            "unknown",
            "unknown",
        )
    }

    object specie {

        val specieModel = SpeciesModel(
            "Yoda's species",
            "Galactic basic",
            "http://swapi.dev/api/planets/28/",
        )

        val speciePresenter = SpeciesPresenter(
            "Yoda's species",
            "Galactic basic",
            "http://swapi.dev/api/planets/28/",
        )

    }

    object lists {
        val listOfCharacters = listOf(characters.characterModel)
        val listOfFilms = listOf(films.filmModel)
        val listOfSpecie = listOf(specie.specieModel)
    }

    object search {
        val empty_search = "DEJAVU"
        val searchWithValues = "Yoda"
        val searchWithError = "I am the Error"
    }

    object urls{
        val urlWithError = "/api/with_the_error"
        val urlValid = "/api/"
    }

    object characterWithUrl{
        val characterWithValidUrl = CharacterPresenter(
            "Yoda",
            "180",
            "5.91",
            "896BBY",
            urls.urlValid
        )
        val characterWithErrorUrl = CharacterPresenter(
            "Yoda",
            "180",
            "5.91",
            "896BBY",
            urls.urlWithError
        )
    }


}