package com.test.walletapp.network.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.walletapp.model.AuthenticationDTO
import com.test.walletapp.model.AuthenticationTokenDTO
import com.test.walletapp.model.Client
import com.test.walletapp.network.ApiHelper
import com.test.walletapp.network.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class MainViewModel(
    private val apiHelper: ApiHelper,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Client>>(UiState.Loading)

    val uiState: StateFlow<UiState<Client>> = _uiState




    fun getClient(id: Int) {
        viewModelScope.launch {
            try {
                println("test")
                _uiState.value = UiState.Loading
                val response = apiHelper.getClient(id).firstOrNull()
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