package com.vu.networkexample.homescreen.data

import com.squareup.moshi.Json

data class AddItemRequest(
    @Json(name = "name") val name: String,
    @Json(name = "data") val data: Map<String, String>
)
