package com.example.finn

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class SchedulersImpl : Schedulers {

    override fun ui() = AndroidSchedulers.mainThread()

    override fun io() = io.reactivex.rxjava3.schedulers.Schedulers.io()

    override fun computer() = io.reactivex.rxjava3.schedulers.Schedulers.computation()
}