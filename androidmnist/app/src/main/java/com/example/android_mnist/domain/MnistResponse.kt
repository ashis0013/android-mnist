package com.example.android_mnist.domain

data class MnistResponse(
    val pred: Int
)

data class MnistRequest(val file: String)