package com.io1.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _isloading = MutableStateFlow(true)
    val isloading = _isloading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            _isloading.value = false
        }
    }
}