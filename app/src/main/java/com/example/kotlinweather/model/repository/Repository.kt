package com.example.kotlinweather.model.repository

import com.example.kotlinweather.model.entities.Weather

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorage(): Weather
}