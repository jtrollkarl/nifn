package com.example.finn.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "ad-type")
    val adType: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "image")
    val image: Image?,
    @Json(name = "location")
    val location: String?,
    @Json(name = "price")
    val price: Price?,
    @Json(name = "score")
    val score: String?,
    @Json(name = "tracking")
    val tracking: Tracking?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "version")
    val version: String?
)