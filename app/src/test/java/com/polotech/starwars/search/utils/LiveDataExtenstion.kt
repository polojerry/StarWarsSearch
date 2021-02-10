package com.polotech.starwars.search.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeForTesting(block: (ValueObserver<T>) -> Unit) {
    val observer = ValueObserver<T>()
    try {
        observeForever(observer)
        block(observer)
    } finally {
        removeObserver(observer)
    }
}

class ValueObserver<T> : Observer<T> {
    val values = mutableListOf<T>()
    override fun onChanged(t: T) {
        values.add(t)
    }

}