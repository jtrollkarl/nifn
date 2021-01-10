package com.example.finn.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "height")
    val height: Int?,
    @Json(name = "scalable")
    val scalable: Boolean?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "width")
    val width: Int?
)