package com.example.finn

import com.example.finn.data.DiscoverResult
import io.reactivex.Single
import retrofit2.http.GET

interface DiscoverApi {

    @GET("/discover.json")
    fun fetchAds(): Single<DiscoverResult>

}