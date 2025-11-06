package com.example.cleanmvvm.data.remote

import com.example.cleanmvvm.data.remote.dto.CountryDto
import okhttp3.Interceptor
import retrofit2.http.GET

interface CountryLayerApi {
    private fun addApiKey(chain: Interceptor.Chain) = chain.proceed(
        chain.request()
            .newBuilder()
            .url(chain.request().url.newBuilder()
                .addQueryParameter("api-access_key", API_KEY).build()
            )
            .build()
    )

    @GET("/v2/all")
    suspend fun getCountries(): List<CountryDto>

    companion object {
        const val API_KEY = "fe776014585e221d99c208f2058c842a"
    }
}