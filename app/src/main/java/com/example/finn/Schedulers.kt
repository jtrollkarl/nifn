package com.example.finn

import io.reactivex.rxjava3.core.Scheduler

interface Schedulers {

    fun ui(): Scheduler

    fun io(): Scheduler

    fun computer(): Scheduler
}