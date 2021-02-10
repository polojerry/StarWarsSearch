package utils

import fakes.Constants.CHARACTER_NAME
import fakes.Constants.CHARACTER_NAME_WITH_NO_SPECIE
import fakes.Constants.URLS.CHARACTER_URL
import fakes.Constants.URLS.CHARACTER_URL_WITH_NO_SPECIE
import fakes.Constants.URLS.EMPTY_SPECIE_URL
import fakes.Constants.URLS.FILM_URL
import fakes.Constants.URLS.PLANET_URL
import fakes.Constants.URLS.SPECIE_URL
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

class StarWarsApiRequestDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/people/?search=$CHARACTER_NAME" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(MockResponseFileReader("json_responses/character_search_response.json").content)
            }
            CHARACTER_URL -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(MockResponseFileReader("json_responses/character_with_details_response.json").content)
            }

            PLANET_URL -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(MockResponseFileReader("json_responses/planet_fetch_response.json").content)
            }
            SPECIE_URL -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(MockResponseFileReader("json_responses/specie_fetch_response.json").content)
            }
            FILM_URL -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(MockResponseFileReader("json_responses/film_fetch_response.json").content)
            }

            else -> MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
        }


    }
}