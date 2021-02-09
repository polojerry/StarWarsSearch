package com.polotech.starwars.domain.models.error

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorModel
}