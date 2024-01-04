package com.test.walletapp.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.walletapp.network.viewmodels.LoginViewModel
import com.test.walletapp.network.viewmodels.MainViewModel
import com.test.walletapp.network.viewmodels.AddBeneficiaryViewModel
import com.test.walletapp.network.viewmodels.TransferViewModel


class ViewModelFactory(
    private val apiHelper: ApiHelper,
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(apiHelper) as T
        }
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(apiHelper) as T
        }
        if (modelClass.isAssignableFrom(AddBeneficiaryViewModel::class.java)) {
            return AddBeneficiaryViewModel(apiHelper) as T
        }
        if (modelClass.isAssignableFrom(TransferViewModel::class.java)) {
            return TransferViewModel(apiHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}