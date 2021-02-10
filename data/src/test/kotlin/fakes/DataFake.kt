package fakes

import com.polotech.starwars.data.remote.models.*
import com.polotech.starwars.data.remote.util.DataConstants
import com.polotech.starwars.domain.models.*
import java.net.HttpURLConnection

object DataFake {

    object characters {
        val characterModel = CharacterModel(
            "Yoda",
            "66",
            "896BBY",
            "http://swapi.dev/api/people/20/"
        )

        val characterNetwork = CharacterNetwork(
            "Yoda",
            "66",
            "896BBY",
            "http://swapi.dev/api/people/20/"
        )

    }

    object charactersWithDetails {

        val characterWithDetailsModel = CharacterWithDetailsModel(
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

        val characterWithDetailsNetwork = CharacterWithDetailsNetwork(
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

        val filmNetwork = FilmNetwork(
            "The Empire Strikes Back",
            "It is a dark time for the\\r\\nRebellion. Although the Death\\r\\nStar has been destroyed,\\r\\nImperial troops have driven the\\r\\nRebel forces from their hidden\\r\\nbase and pursued them across\\r\\nthe galaxy.\\r\\n\\r\\nEvading the dreaded Imperial\\r\\nStarfleet, a group of freedom\\r\\nfighters led by Luke Skywalker\\r\\nhas established a new secret\\r\\nbase on the remote ice world\\r\\nof Hoth.\\r\\n\\r\\nThe evil lord Darth Vader,\\r\\nobsessed with finding young\\r\\nSkywalker, has dispatched\\r\\nthousands of remote probes into\\r\\nthe far reaches of space....\"",
        )

    }

    object planet {
        val planetModel = PlanetModel(
            "unknown",
            "unknown",
        )

        val planetNetwork = PlanetNetwork(
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

        val specieNetwork = SpeciesNetwork(
            "Yoda's species",
            "Galactic basic",
            "http://swapi.dev/api/planets/28/",
        )

    }
}