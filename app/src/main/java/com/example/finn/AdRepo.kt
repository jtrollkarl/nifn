package com.example.finn

import io.reactivex.rxjava3.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class AdRepo @Inject constructor(
    private val api: DiscoverApi,
    private val schedulers: Schedulers
) {

    private val disposable = CompositeDisposable()

    fun getAds() {
        disposable.add(api.fetchAds()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe(
                { result ->
                    Timber.d(result.toString())
                },
                { e ->
                    Timber.e(e)
                }
            ))
    }

    fun saveFavourite(){

    }

    fun clearDisposables() {
        disposable.clear()
    }
}