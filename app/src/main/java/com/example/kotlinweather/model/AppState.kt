package com.example.kotlinweather.model

import com.example.kotlinweather.model.entites.Weather

sealed class AppState {
    data class Success(val weatherData: List<Weather>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}