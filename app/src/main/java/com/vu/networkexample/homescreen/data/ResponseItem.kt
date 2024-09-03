package com.vu.networkexample.homescreen.data

import com.squareup.moshi.Json

data class ResponseItem(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "data") val data: Map<String, String>?
)