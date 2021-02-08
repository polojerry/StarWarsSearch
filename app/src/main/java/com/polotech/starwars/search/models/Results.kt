package com.polotech.starwars.search.models

sealed class Results<T> {
    class Loading<T> : Results<T>()
    data class Success<T>(val data: T) : Results<T>()
    data class Failed<T>(val throwable: Throwable) : Results<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(throwable: Throwable) = Failed<T>(throwable)
    }
}