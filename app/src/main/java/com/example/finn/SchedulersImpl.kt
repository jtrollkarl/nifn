package com.example.finn

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers.computation


class SchedulersImpl : Schedulers {

    override fun ui() = AndroidSchedulers.mainThread()

    override fun io() = io.reactivex.rxjava3.schedulers.Schedulers.io()

    override fun computer() = computation()
}