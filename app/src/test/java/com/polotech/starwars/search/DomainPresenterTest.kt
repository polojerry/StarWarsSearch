package com.polotech.starwars.search

import com.polotech.starwars.search.fakes.DataFake
import com.polotech.starwars.search.mappers.toPresentation
import org.junit.Assert
import org.junit.Test

class DomainPresenterTest {

    @Test
    fun `when characterToPresenter is called, it should return the correct characterPresenter`() {
        val characterModel = DataFake.characters.characterModel
        val presenterCharacter = characterModel.toPresentation()

        Assert.assertEquals(presenterCharacter.name, DataFake.characters.characterPresenter.name)
        Assert.assertEquals(presenterCharacter.heightInCm,
            DataFake.characters.characterPresenter.heightInCm)
        Assert.assertEquals(presenterCharacter.heightInFeet,
            DataFake.characters.characterPresenter.heightInFeet)
        Assert.assertEquals(presenterCharacter.birthYear,
            DataFake.characters.characterPresenter.birthYear)
        Assert.assertEquals(presenterCharacter.url, DataFake.characters.characterPresenter.url)
    }

    @Test
    fun `when planetModelToPresentation is called, it should return the correct planetPresentation`() {
        val modelPlanet = DataFake.planet.planetModel
        val presentationPlanet = modelPlanet.toPresentation()

        Assert.assertEquals(presentationPlanet.name, DataFake.planet.planetPresenter.name)
        Assert.assertEquals(presentationPlanet.population,
            DataFake.planet.planetPresenter.population)
    }

    @Test
    fun `when specieModelToPresentation is called, it should return the correct speciePresentation`() {
        val modelSpecie = DataFake.specie.specieModel
        val presentationSpecie = modelSpecie.toPresentation()

        Assert.assertEquals(presentationSpecie.name, DataFake.specie.speciePresenter.name)
        Assert.assertEquals(presentationSpecie.language, DataFake.specie.speciePresenter.language)
        Assert.assertEquals(presentationSpecie.homeWorld, DataFake.specie.speciePresenter.homeWorld)
    }

    @Test
    fun `when filmModelToPresentation is called, it should return the correct filmPresentation`() {
        val modelFilm = DataFake.films.filmModel
        val presentationFilm = modelFilm.toPresentation()

        Assert.assertEquals(presentationFilm.title, DataFake.films.filmPresentation.title)
        Assert.assertEquals(presentationFilm.openingCrawl,
            DataFake.films.filmPresentation.openingCrawl)
    }
}