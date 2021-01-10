package com.example.finn.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Adobe(
    @Json(name = "category")
    val category: String?,
    @Json(name = "event_name")
    val eventName: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "url")
    val url: String?
)