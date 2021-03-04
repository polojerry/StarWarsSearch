package mappers

import com.polotech.starwars.data.remote.mapper.toDomain
import fakes.DataFake
import org.junit.Assert
import org.junit.Test

class NetworkToDomainMapperTest {

    @Test
    fun `when characterNetworkToDomain is called, it should return the correct characterModel`(){
        val networkCharacter = DataFake.characters.characterNetwork
        val domainCharacter = networkCharacter.toDomain()

        Assert.assertEquals(domainCharacter.name, DataFake.characters.characterModel.name)
        Assert.assertEquals(domainCharacter.birthYear, DataFake.characters.characterModel.birthYear)
        Assert.assertEquals(domainCharacter.height, DataFake.characters.characterModel.height)
        Assert.assertEquals(domainCharacter.url, DataFake.characters.characterModel.url)

    }

    @Test
    fun `when characterWithDetailsNetworkToDomain is called, it should return the correct characterWithDetailsModel`(){
        val networkCharacterWithDetails = DataFake.charactersWithDetails.characterWithDetailsNetwork
        val domainCharacterWithDetails = networkCharacterWithDetails.toDomain()

        Assert.assertEquals(domainCharacterWithDetails.name, DataFake.charactersWithDetails.characterWithDetailsModel.name)
        Assert.assertEquals(domainCharacterWithDetails.birthYear, DataFake.charactersWithDetails.characterWithDetailsModel.birthYear)
        Assert.assertEquals(domainCharacterWithDetails.height, DataFake.charactersWithDetails.characterWithDetailsModel.height)
        Assert.assertEquals(domainCharacterWithDetails.url, DataFake.charactersWithDetails.characterWithDetailsModel.url)
        Assert.assertEquals(domainCharacterWithDetails.planetUrl, DataFake.charactersWithDetails.characterWithDetailsModel.planetUrl)
        Assert.assertEquals(domainCharacterWithDetails.speciesUrls, DataFake.charactersWithDetails.characterWithDetailsModel.speciesUrls)
        Assert.assertEquals(domainCharacterWithDetails.filmUrls, DataFake.charactersWithDetails.characterWithDetailsModel.filmUrls)
    }

    @Test
    fun `when planetNetworkToDomain is called, it should return the correct planetModel`(){
        val networkPlanet = DataFake.planet.planetNetwork
        val domainPlanet = networkPlanet.toDomain()

        Assert.assertEquals(domainPlanet.name, DataFake.planet.planetModel.name)
        Assert.assertEquals(domainPlanet.population, DataFake.planet.planetModel.population)
    }

    @Test
    fun `when specieNetworkToDomain is called, it should return the correct specieModel`(){
        val networkSpecie = DataFake.specie.specieNetwork
        val domainSpecie = networkSpecie.toDomain()

        Assert.assertEquals(domainSpecie.name, DataFake.specie.specieModel.name)
        Assert.assertEquals(domainSpecie.language, DataFake.specie.specieModel.language)
        Assert.assertEquals(domainSpecie.homeWorld, DataFake.specie.specieModel.homeWorld)
    }

    @Test
    fun `when filmNetworkToDomain is called, it should return the correct filmModel`(){
        val networkFilm = DataFake.films.filmNetwork
        val domainFilm = networkFilm.toDomain()

        Assert.assertEquals(domainFilm.title, DataFake.films.filmModel.title)
        Assert.assertEquals(domainFilm.openingCrawl, DataFake.films.filmModel.openingCrawl)
    }
}