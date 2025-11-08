package com.example.cleanmvvm.presentation.country_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanmvvm.common.Constants
import com.example.cleanmvvm.common.Resource
import com.example.cleanmvvm.domain.use_case.get_country_by_code.GetCountryByCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val getCountryByCodeUseCase: GetCountryByCodeUseCase,
    private val savedStateHandle: SavedStateHandle // this is the bundle that contains the nav args
): ViewModel() {
    private val _state = mutableStateOf(CountryDetailState())
    val state : State<CountryDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COUNTRY_CODE_KEY)?.let { countryCode ->
            getCountryByCode(countryCode)
        }
    }

    private fun getCountryByCode(code: String) {
        getCountryByCodeUseCase(code).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = CountryDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CountryDetailState(country = result.data)
                }
                is Resource.Error -> {
                    _state.value = CountryDetailState(error = result.message ?: "An unexpected error occurred")
                }
            }

        }.launchIn(viewModelScope)
    }
}