package com.example.finn.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tracking(
    @Json(name = "actions")
    val actions: Actions?,
    @Json(name = "adobe")
    val adobe: Adobe?,
    @Json(name = "ec")
    val ec: Ec?
)