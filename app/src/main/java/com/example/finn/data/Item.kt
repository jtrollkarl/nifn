package com.example.finn.data


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "items")
@JsonClass(generateAdapter = true)
data class Item(
    @ColumnInfo(name = "ad_type")
    @Json(name = "ad-type")
    val adType: String?,
    @Json(name = "description")
    val description: String?,
    @PrimaryKey
    @Json(name = "id")
    val id: String,
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