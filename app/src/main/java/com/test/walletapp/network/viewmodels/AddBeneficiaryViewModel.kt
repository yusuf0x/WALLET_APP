package com.test.walletapp.network.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.walletapp.model.Client
import com.test.walletapp.model.SpinnerModel
import com.test.walletapp.network.ApiHelper
import com.test.walletapp.network.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class AddBeneficiaryViewModel(
    private val apiHelper: ApiHelper,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<SpinnerModel?>>(UiState.Loading)

    val uiState: StateFlow<UiState<SpinnerModel?>> = _uiState




    fun postBeneficiary(id: Int,body:SpinnerModel) {
        viewModelScope.launch {
            try {
                println("test")
                _uiState.value = UiState.Loading
                val response = apiHelper.postBeneficiary(id,body).firstOrNull()
                _uiState.value = if (response != null) {
                    UiState.Success(response)
                } else {
                    UiState.Error("Not Found")
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error("An error occurred: ${e.message}")
            }
        }
    }



}