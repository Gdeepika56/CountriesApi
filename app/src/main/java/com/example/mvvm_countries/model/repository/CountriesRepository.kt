package com.example.mvvm_countries.model.repository

import com.example.mvvm_countries.model.data.CountriesItem
import com.example.mvvm_countries.model.remote.ApiService
import com.example.mvvm_countries.model.remote.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountriesRepository @Inject constructor(private val apiService: ApiService) {

    fun getAllCountries(): Flow<ApiState<List<CountriesItem>>> = flow {
        emit(ApiState.Loading)
        try {
            val response = apiService.getCountries()
            if (response.isSuccessful){
                response.body()?.let{
                    emit(ApiState.Success(it))
                }?:emit(ApiState.Error("Error:No response"))
            }else{
                emit(ApiState.Error("Error: ${response.code()}"))
            }

        }catch (e:Exception){
            emit(ApiState.Error("Error:${e.localizedMessage}"))
        }
    }
}