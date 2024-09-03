package com.vu.networkexample.homescreen.network

import com.vu.networkexample.homescreen.data.AddItemRequest
import com.vu.networkexample.homescreen.data.AddItemResponse
import com.vu.networkexample.homescreen.data.ResponseItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestfulDevApiService {

    @GET("objects")
    suspend fun getAllObjects(): List<ResponseItem>

    @GET("objects/{id}")
    suspend fun getObjectById(@Path("id") id: Int): ResponseItem

    @POST("objects")
    suspend fun addObject( @Body data: AddItemRequest): AddItemResponse
}