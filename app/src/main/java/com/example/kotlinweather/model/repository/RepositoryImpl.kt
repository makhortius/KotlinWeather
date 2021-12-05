package com.example.kotlinweather.model.repository

import com.example.kotlinweather.model.entites.City
import com.example.kotlinweather.model.entites.Weather

class RepositoryImpl : Repository {
    override fun getWeatherFromServer(lat: Double, lng: Double ): Weather {
        val dto = WeatherRepo.api.getWeather(lat, lng).execute().body()
        /*val dto = WeatherRepo.api.getWeather(lat, lng).enqueue(object : Callback<WeatherDTO> {
            override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
                TODO("Not yet implemented")
                if(response.isSuccessful) {
                    ///
                } else {
                    //....
                }
            }

            override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })*/
        return Weather(
            temperature = dto?.fact?.temp ?: 0,
            feelsLike = dto?.fact?.feelsLike ?: 0,
            condition = dto?.fact?.condition
        )
    }

    override fun getWeatherFromLocalStorageRus() = City.getRussianCities()

    override fun getWeatherFromLocalStorageWorld() = City.getWorldCities()
}