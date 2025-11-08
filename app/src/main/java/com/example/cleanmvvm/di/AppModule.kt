package com.example.cleanmvvm.di

import com.example.cleanmvvm.common.Constants.API_KEY
import com.example.cleanmvvm.common.Constants.BASE_URL
import com.example.cleanmvvm.data.remote.CountryLayerApi
import com.example.cleanmvvm.data.repository.CountryRepositoryImpl
import com.example.cleanmvvm.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private fun addApiKeyToUrl(chain: Interceptor.Chain) = chain.proceed(
        chain.request()
            .newBuilder()
            .url(chain.request().url.newBuilder()
                .addQueryParameter("access_key", API_KEY).build()
            )
            .build()
    )

    @Provides
    @Singleton
    fun provideCountryLayerApi(): CountryLayerApi {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain -> return@addInterceptor addApiKeyToUrl(chain) }
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryLayerApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCountryRepository(
        api: CountryLayerApi
    ): CountryRepository {
        return CountryRepositoryImpl(api)
    }
}