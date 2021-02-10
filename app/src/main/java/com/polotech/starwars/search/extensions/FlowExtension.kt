package com.polotech.starwars.search.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion

fun <T> Flow<T>.doOnError(onError: (Throwable) -> Unit): Flow<T> {
    return this.onCompletion {
        if (it != null) {
            onError(it)
        }
    }
}