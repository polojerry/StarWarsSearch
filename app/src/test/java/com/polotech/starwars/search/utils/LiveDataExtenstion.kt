package com.polotech.starwars.search.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/*
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

}*/
/*fun <T> LiveData<T>.observeOnce(owner: LifecycleOwner, observer: (T) -> Unit) {
    observe(owner, object: Observer<T> {
        override fun onChanged(value: T) {
            removeObserver(this)
            observer(value)
        }
    })
}*/

fun <T> LiveData<T>.observeOnce(observer: Observer<T>) {
    observeForever(object : Observer<T> {
        override fun onChanged(t: T?) {
            observer.onChanged(t)
            removeObserver(this)
        }
    })
}

