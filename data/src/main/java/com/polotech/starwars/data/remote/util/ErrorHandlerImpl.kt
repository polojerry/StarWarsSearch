package com.polotech.starwars.data.remote.util

import com.polotech.starwars.domain.models.error.ErrorHandler
import com.polotech.starwars.domain.models.error.ErrorModel
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

class ErrorHandlerImpl : ErrorHandler {
    override fun getError(throwable: Throwable): ErrorModel {
        return when (throwable) {
            is IOException -> ErrorModel.Network
            is HttpException -> {
                when (throwable.code()) {
                    // no cache found in case of no network, thrown by retrofit -> treated as network error
                    DataConstants.Network.HttpStatusCode.UNSATISFIABLE_REQUEST -> ErrorModel.Network

                    // not found
                    HttpURLConnection.HTTP_NOT_FOUND -> ErrorModel.NotFound

                    // access denied
                    HttpURLConnection.HTTP_FORBIDDEN -> ErrorModel.AccessDenied

                    // unavailable service
                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorModel.ServiceUnavailable

                    // all the others will be treated as unknown error
                    else -> ErrorModel.Unknown
                }
            }
            else -> ErrorModel.Unknown
        }
    }
}