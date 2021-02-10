import com.polotech.starwars.data.remote.api.StarWarsApiService
import com.polotech.starwars.data.remote.repositories.CharacterDetailsRepositoryImpl
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import fakes.Constants.URLS.CHARACTER_URL
import fakes.DataFake
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import utils.StarWarsApiRequestDispatcher
import java.util.concurrent.TimeUnit

class CharacterDetailsRepositoryImplTest {

    private var mockWebServer = MockWebServer()
    private lateinit var starWarsApiService: StarWarsApiService
    private lateinit var okHttpClient: OkHttpClient

    private lateinit var characterDetailsRepository: CharacterDetailsRepository

    @Before
    fun setup() {
        mockWebServer.apply {
            dispatcher = StarWarsApiRequestDispatcher()
        }.start()

        setUpOkHttpClient()
        setUpStarWarsApiService()

        characterDetailsRepository = CharacterDetailsRepositoryImpl(starWarsApiService)

    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `when character url is supplied for character details, a characterWithDetailsModel should be returned`(){
        runBlocking{
            val characterWithDetails = characterDetailsRepository.fetchCharacterDetail(CHARACTER_URL).first()
            Assert.assertNotNull(characterWithDetails)
        }
    }

    @Test
    fun `when character url is supplied fo fetch planet, a planetModel should be return `(){
        runBlocking {
            val planet = characterDetailsRepository.fetchPlanet(CHARACTER_URL).first()
            Assert.assertEquals(planet, DataFake.planet.planetModel)
            Assert.assertEquals(planet.name, DataFake.planet.planetModel.name)
        }
    }

    @Test
    fun `when character url is supplied fo fetch specie, a list of specieModel should be return `(){
        runBlocking {
            val species = characterDetailsRepository.fetchSpecies(CHARACTER_URL).first()
            Assert.assertEquals(species.size,1)
        }
    }

    @Test
    fun `when character url is supplied fo fetch films, a list of filmModels should be return `(){
        runBlocking {
            val films = characterDetailsRepository.fetchFilms(CHARACTER_URL).first()
            Assert.assertEquals(films.size,5)
        }
    }

    private fun setUpOkHttpClient() {
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .build()

    }

    private fun setUpStarWarsApiService() {
        starWarsApiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(StarWarsApiService::class.java)
    }
}