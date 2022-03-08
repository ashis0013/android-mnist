package com.example.android_mnist.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_mnist.domain.MnistServiceImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(): ViewModel() {

    var isLoading = false
    var predictedValue = MutableLiveData("")

    fun startLoading() {
        isLoading = true
        viewModelScope.launch {
            while (isLoading) {
                predictedValue.value = (0..9).random().toString()
                delay(10L)
            }
        }
    }

    fun stopLoading() {
        isLoading = false
    }

    fun getPrediction(imageString: String) {
        println(imageString)
        viewModelScope.launch {
            val response = try {
                val bruh = MnistServiceImpl.apiService.getPrediction(imageString)
                bruh.body()?.pred?: 0
            } catch (e: Exception) {
                Log.e(TAG, "getPrediction: Exception!!${e.message}")
                -1
            }
            predictedValue.value = response.toString()
        }
    }
}