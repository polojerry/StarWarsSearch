package com.polotech.starwars.domain.models.error

sealed class ErrorModel {

    object Network : ErrorModel()

    object NotFound : ErrorModel()

    object AccessDenied : ErrorModel()

    object ServiceUnavailable : ErrorModel()

    object Unknown : ErrorModel()
}