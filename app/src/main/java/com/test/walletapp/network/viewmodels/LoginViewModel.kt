package com.test.walletapp.network.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.walletapp.model.AuthenticationDTO
import com.test.walletapp.model.AuthenticationTokenDTO
import com.test.walletapp.network.ApiHelper
import com.test.walletapp.network.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class LoginViewModel(
    private val apiHelper: ApiHelper,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<AuthenticationTokenDTO>>(UiState.Loading)

    val uiState: StateFlow<UiState<AuthenticationTokenDTO>> = _uiState


    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                println("test")
                _uiState.value = UiState.Loading
                val response = apiHelper.postEmail(AuthenticationDTO(email, password)).firstOrNull()
                _uiState.value = if (response != null) {
                    UiState.Success(response)
                } else {
                    UiState.Error("Invalid credentials")
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error("An error occurred: ${e.message}")
            }
        }
    }

}