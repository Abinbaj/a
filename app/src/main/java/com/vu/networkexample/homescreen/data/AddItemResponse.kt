package com.vu.networkexample.homescreen.data

import com.squareup.moshi.Json

data class AddItemResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "data") val data: Map<String, String>,
    @Json(name = "createdAt") val timeStamp: String
)
