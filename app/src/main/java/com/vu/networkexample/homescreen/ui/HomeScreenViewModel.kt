package com.vu.networkexample.homescreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {

    private val _text = MutableStateFlow("Initial Text")
    val text: StateFlow<String> = _text

    init {
        updateTextAfterDelay()
    }

    private fun updateTextAfterDelay() {

        viewModelScope.launch {
            delay(2000) // 2 second delay
            _text.value = "Text updated after delay!"
        }
    }
}