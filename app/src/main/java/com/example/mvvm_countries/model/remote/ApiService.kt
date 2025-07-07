package com.example.mvvm_countries.model.remote

import com.example.mvvm_countries.commons.Constants.Countries_Endpoint
import com.example.mvvm_countries.model.data.CountriesItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Countries_Endpoint)
    suspend fun getCountries():Response<List<CountriesItem>>
}