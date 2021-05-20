package com.polotech.starwars.feature.details.models

import com.polotech.starwars.domain.models.error.ErrorModel

sealed class Results<T> {
    class Loading<T> : Results<T>()
    data class Success<T>(val data: T) : Results<T>()
    data class Failed<T>(val error : ErrorModel) : Results<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(error : ErrorModel) = Failed<T>(error)
    }
}