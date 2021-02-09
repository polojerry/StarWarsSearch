package fakeRepoitory

import com.polotech.starwars.domain.models.*

object DataFake {

    object characters {
        val character = CharacterModel(
            "Yoda",
            "66",
            "896BBY",
            "http://swapi.dev/api/people/20/"
        )

        val character1 = CharacterModel(
            "Boba Fett",
            "183",
            "31.5BBY",
            "http://swapi.dev/api/people/22/"
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

        val character1 = CharacterWithDetailsModel(
            "Boba Fett",
            "183",
            "31.5BBY",
            "http://swapi.dev/api/people/22/",
            listOf(
                "http://swapi.dev/api/films/2/",
                "http://swapi.dev/api/films/3/",
                "http://swapi.dev/api/films/5/",
            ),
            "http://swapi.dev/api/planets/10/",
            listOf()
        )

    }

    object films {
        val film = FilmModel(
            "The Empire Strikes Back",
            "It is a dark time for the\\r\\nRebellion. Although the Death\\r\\nStar has been destroyed,\\r\\nImperial troops have driven the\\r\\nRebel forces from their hidden\\r\\nbase and pursued them across\\r\\nthe galaxy.\\r\\n\\r\\nEvading the dreaded Imperial\\r\\nStarfleet, a group of freedom\\r\\nfighters led by Luke Skywalker\\r\\nhas established a new secret\\r\\nbase on the remote ice world\\r\\nof Hoth.\\r\\n\\r\\nThe evil lord Darth Vader,\\r\\nobsessed with finding young\\r\\nSkywalker, has dispatched\\r\\nthousands of remote probes into\\r\\nthe far reaches of space....\"",
        )
        val film1 = FilmModel(
            "Return of the Jedi",
            "Luke Skywalker has returned to\r\nhis home planet of Tatooine in\r\nan attempt to rescue his\r\nfriend Han Solo from the\r\nclutches of the vile gangster\r\nJabba the Hutt.\r\n\r\nLittle does Luke know that the\r\nGALACTIC EMPIRE has secretly\r\nbegun construction on a new\r\narmored space station even\r\nmore powerful than the first\r\ndreaded Death Star.\r\n\r\nWhen completed, this ultimate\r\nweapon will spell certain doom\r\nfor the small band of rebels\r\nstruggling to restore freedom\r\nto the galaxy...",
        )
    }

    object planet {
        val planet = PlanetModel(
            "unknown",
            "unknown",
        )

        val planet1 = PlanetModel(
            "Kamino",
            "1000000000",
        )
    }

    object specie {

        val specie = SpeciesModel(
            "Yoda's species",
            "Galactic basic",
            "http://swapi.dev/api/planets/28/",
        )

        val specie1 = SpeciesModel(
            "Kaminoan",
            "Kaminoan",
            "http://swapi.dev/api/species/32/",
        )

    }


}