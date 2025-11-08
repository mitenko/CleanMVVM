package com.example.cleanmvvm.domain.use_case.get_countries

import com.example.cleanmvvm.common.Resource
import com.example.cleanmvvm.domain.model.Country
import com.example.cleanmvvm.domain.model.toCountry
import com.example.cleanmvvm.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())
            val countries = repository.getCountries().map { it.toCountry() }
            emit(Resource.Success(countries))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}