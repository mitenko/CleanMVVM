package com.example.cleanmvvm.data.remote

import com.example.cleanmvvm.data.remote.dto.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryLayerApi {
    @GET("/v2/all")
    suspend fun getCountries(): List<CountryDto>

    @GET("/v2/capital/{capital}")
    suspend fun getCountryByCapital(@Path("capital") capital: String): List<CountryDto>

    @GET("v2/alpha/{code}")
    suspend fun getCountryByCode(@Path("code") code: String): CountryDto
}