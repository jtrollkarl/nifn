package com.example.finn.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Price(
    @Json(name = "total")
    val total: Int?,
    @Json(name = "value")
    val value: Int?
)