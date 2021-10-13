package com.example.kotlinweather.di

import com.example.kotlinweather.model.repository.Repository
import com.example.kotlinweather.model.repository.RepositoryImpl
import com.example.kotlinweather.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl() }

    //View models
    viewModel { MainViewModel(get()) }
}