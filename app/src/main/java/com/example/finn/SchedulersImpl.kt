package com.example.finn

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers.computation
import javax.inject.Inject


class SchedulersImpl @Inject constructor() : Schedulers {

    override fun ui() = AndroidSchedulers.mainThread()

    override fun io() = io.reactivex.rxjava3.schedulers.Schedulers.io()

    override fun compute() = computation()
}