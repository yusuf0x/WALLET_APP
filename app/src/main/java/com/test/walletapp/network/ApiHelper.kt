package com.test.walletapp.network

import com.test.walletapp.model.Client
import com.test.walletapp.model.MultiTransfer
import com.test.walletapp.model.SpinnerModel
import kotlinx.coroutines.flow.Flow

interface ApiHelper {
    
    fun getClient(id: Int?): Flow<Client?>

    
    fun getListOfBeneficiaries(id: Int?): Flow<List<SpinnerModel?>?>

    
    fun postBeneficiary(id: Int?, body: SpinnerModel?): Flow<SpinnerModel?>

    
    fun getMultiTransfers(id: Int?): Flow<List<MultiTransfer?>?>

    
    fun postTransfer(id: Int?, body: MultiTransfer?): Flow<MultiTransfer?>

    
    fun getTransfer(id: Int?, reference: String?): Flow<MultiTransfer?>

    
    fun putTransfer(id: Int?, reference: String?, motif: String?): Flow<MultiTransfer?>
}