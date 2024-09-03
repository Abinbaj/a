package com.vu.networkexample.homescreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.networkexample.homescreen.data.ResponseItem
import com.vu.networkexample.homescreen.data.RestfulDevApiRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {

    private val repository = RestfulDevApiRepository()

    private val mutableObjectsState = MutableStateFlow<List<ResponseItem>>(emptyList())
    val objectsState: StateFlow<List<ResponseItem>> = mutableObjectsState

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState

    fun getAllObjects() {
        viewModelScope.launch {
            try {
                val objects = repository.getAllObjects()
                mutableObjectsState.value = objects
            } catch (e: Exception) {
                _errorState.value = "Error fetching objects: ${e.message}"
            }
        }
    }
}