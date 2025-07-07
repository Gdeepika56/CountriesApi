package com.example.mvvm_countries.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_countries.model.data.CountriesItem
import com.example.mvvm_countries.model.remote.ApiState
import com.example.mvvm_countries.model.repository.CountriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel  @Inject constructor(private val repository: CountriesRepository):ViewModel(){

    private val _country = MutableStateFlow<ApiState<List<CountriesItem>>>(ApiState.Loading)
    val country : MutableStateFlow<ApiState<List<CountriesItem>>> = _country

    fun fetchAllCountries(){
        viewModelScope.launch {
            repository.getAllCountries()
                .collect { data->
                    _country.value = data
                }
        }
    }

}