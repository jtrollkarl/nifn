package com.example.finn.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ec(
    @Json(name = "click")
    val click: List<String>?,
    @Json(name = "inScreen")
    val inScreen: List<String>?
)