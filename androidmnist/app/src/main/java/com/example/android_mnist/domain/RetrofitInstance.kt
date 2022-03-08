package com.example.android_mnist.domain

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object MnistServiceImpl {
    val apiService: MnistService by lazy {
        Retrofit.Builder().baseUrl("https://mnist-flask-pytorch-ashis.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}