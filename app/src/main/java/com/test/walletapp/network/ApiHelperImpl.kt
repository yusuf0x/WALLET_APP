package com.test.walletapp.network

import com.test.walletapp.model.Client
import com.test.walletapp.model.MultiTransfer
import com.test.walletapp.model.SpinnerModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiHelperImpl(private  val apiService: ApiService) : ApiHelper {
    override fun getClient(id: Int?) =   flow {
       emit(apiService.getclient(id))
    }

    override fun getListOfBeneficiaries(id: Int?) = flow {
        emit(apiService.getlistbenef(id))
    }

    override fun postBeneficiary(id: Int?, body: SpinnerModel?)= flow {
        emit(apiService.postbenef(id,body))
    }

    override fun getMultiTransfers(id: Int?) = flow {
        emit(apiService.getMultitransfers(id))
    }

    override fun postTransfer(id: Int?, body: MultiTransfer?) = flow {
        emit(apiService.postTransfer(id,body))
    }

    override fun getTransfer(id: Int?, reference: String?) = flow {
            emit(apiService.getTransfer(id,reference))
    }

    override fun putTransfer(id: Int?, reference: String?, motif: String?)  = flow {
        emit(apiService.putTransfer(id,reference,motif))
    }

}