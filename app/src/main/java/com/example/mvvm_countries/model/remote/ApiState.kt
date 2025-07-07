package com.example.mvvm_countries.model.remote

sealed class ApiState<out T> {
    object Loading: ApiState<Nothing>()
    data class Success<out T>(val data :T): ApiState<T>()
    data class Error(val error:String): ApiState<Nothing>()

}