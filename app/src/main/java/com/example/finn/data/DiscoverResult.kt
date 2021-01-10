package com.example.finn.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DiscoverResult(
    @Json(name = "fetchMore")
    val fetchMore: List<Any>?,
    @Json(name = "items")
    val items: List<Item>?,
    @Json(name = "size")
    val size: Int?,
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "version")
    val version: String?
)