package com.hms.observable

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.lang.Exception

fun main(args: Array<String>){


    val observer: Observer<String> = object : Observer<String>{
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


    val observable: Observable<String> = Observable.create<String>{
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onComplete()
    }

    observable.subscribe(observer)

    val observable2: Observable<String> = Observable.create<String>{
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onError(Exception("My Custom Error Exception"))
    }

    observable2.subscribe(observer)
}