package com.example.kotlinweather.model.repository

import com.example.kotlinweather.model.entites.Weather

interface Repository {
    fun getWeatherFromServer(lat: Double, lng: Double): Weather
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>
}