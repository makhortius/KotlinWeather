package com.example.kotlinweather.model.repository

import com.example.kotlinweather.model.entities.Weather

class RepositoryImpl : Repository {
    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorage() = Weather()
}