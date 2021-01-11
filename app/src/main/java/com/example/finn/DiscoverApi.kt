package com.example.finn

import com.example.finn.data.DiscoverResult
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface DiscoverApi {

    @GET("discover.json")
    fun fetchAds(): Flowable<DiscoverResult>

}