package com.example.android_mnist.domain

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MnistService {
    @FormUrlEncoded
    @POST("predict")
    suspend fun getPrediction(@Field ("file") file: String): Response<MnistResponse>
}