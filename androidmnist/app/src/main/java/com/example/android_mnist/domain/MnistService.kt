package com.example.android_mnist.domain

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MnistService {
    @POST("predict")
    suspend fun getPrediction(@Body req: MnistRequest): Response<MnistResponse>
}