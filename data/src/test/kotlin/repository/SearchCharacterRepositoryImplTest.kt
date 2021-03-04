package repository

import com.polotech.starwars.data.remote.api.StarWarsApiService
import com.polotech.starwars.data.remote.repositories.SearchCharacterRepositoryImpl
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import fakes.Constants.CHARACTER_NAME
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

@ExperimentalCoroutinesApi
class SearchCharacterRepositoryImplTest {

    private var mockWebServer = MockWebServer()
    private lateinit var starWarsApiService: StarWarsApiService
    private lateinit var okHttpClient: OkHttpClient

    private lateinit var searchCharacterRepository: SearchCharacterRepository

    @Before
    fun setup() {
        mockWebServer.apply {
            dispatcher = StarWarsApiRequestDispatcher()
        }.start()

        setUpOkHttpClient()
        setUpStarWarsApiService()

        searchCharacterRepository = SearchCharacterRepositoryImpl(starWarsApiService)

    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `when search parameter is passed, list of character should be returned`() {
        runBlocking {
            val characters = searchCharacterRepository.searchCharacter(CHARACTER_NAME).first()
            Assert.assertEquals(characters.size, 1)
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