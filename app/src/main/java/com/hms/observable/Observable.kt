package com.hms.observable

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import java.util.*


fun main(agrs: Array<String>) {


    val observer: Observer<Any> = object : Observer<Any> {

        override fun onComplete() {
            println("OnComplete")
        }

        override fun onSubscribe(d: Disposable) {
            println("Subscribe to $d")
        }

        override fun onNext(t: Any) {
            println("OnNext Item $t")
        }

        override fun onError(e: Throwable) {
            println("OnError Message $e")
        }

    }

    val observable: Observable<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f).toObservable()
    observable.subscribe(observer)

    val observableList: Observable<List<Any>> = Observable.just(
        listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f),
        listOf("List with Single Item"),
        listOf(1,2,3,4,5,6)
    )
    observableList.subscribe(observer)

}