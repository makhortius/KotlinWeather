package com.example.kotlinweather.model.repository

import com.example.kotlinweather.model.entities.Weather
import com.example.kotlinweather.model.entities.getRussianCities
import com.example.kotlinweather.model.entities.getWorldCities

class RepositoryImpl : Repository {
    override fun getWeatherFromServer() = Weather()
    override fun getWeatherFromLocalStorageRus() = getRussianCities()
    override fun getWeatherFromLocalStorageWorld() = getWorldCities()
}