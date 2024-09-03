package com.vu.networkexample.homescreen.data

import com.vu.networkexample.homescreen.network.RestfulApiDevRetrofitClient
import com.vu.networkexample.homescreen.network.RestfulDevApiService

class RestfulDevApiRepository(private val apiService: RestfulDevApiService = RestfulApiDevRetrofitClient().apiService) {

    suspend fun getAllObjects(): List<ResponseItem> {
        return apiService.getAllObjects()
    }

    suspend fun getObjectById(id: Int): ResponseItem {
        return apiService.getObjectById(id)
    }

    suspend fun addObject(newObject: AddItemRequest): AddItemResponse {
        return apiService.addObject(newObject)
    }
}
