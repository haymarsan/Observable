package com.hms.observable

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {


    val observer: Observer<String> = object : Observer<String> {
        override fun onComplete() {
            println("AllComplete")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }

        override fun onNext(t: String) {
            println("Next $t Item")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

    }

    val list = listOf("String 1","String 2","String 3","String 4")
    
}
