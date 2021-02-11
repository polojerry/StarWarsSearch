package com.polotech.starwars.search.fakes

import com.polotech.starwars.domain.models.CharacterModel
import com.polotech.starwars.domain.models.FilmModel
import com.polotech.starwars.domain.models.PlanetModel
import com.polotech.starwars.domain.models.SpeciesModel
import com.polotech.starwars.search.models.CharacterPresenter
import com.polotech.starwars.search.models.FilmPresenter
import com.polotech.starwars.search.models.PlanetPresenter
import com.polotech.starwars.search.models.SpeciesPresenter
import java.net.HttpURLConnection

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
    }

    object search {
        val empty_search = "DEJAVU"
        val searchWithValues = "Boba"
        val searchWithError = "I am the Error"
    }


}