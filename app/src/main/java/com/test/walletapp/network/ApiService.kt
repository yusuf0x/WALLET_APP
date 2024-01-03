package com.test.walletapp.network

import com.test.walletapp.model.AuthenticationDTO
import com.test.walletapp.model.AuthenticationTokenDTO
import com.test.walletapp.model.Client
import com.test.walletapp.model.MultiTransfer
import com.test.walletapp.model.SpinnerModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @POST("login")
    suspend  fun postemail(@Body body: AuthenticationDTO?): AuthenticationTokenDTO?

    @GET("me/{id}")
    suspend  fun getclient(
        @Path("id") id: Int?
    ): Client?


    @GET("beneficiaires/{id}")
    suspend  fun getlistbenef(
        @Path("id") id: Int?
    ): List<SpinnerModel?>?


    @POST("beneficiaire/{id}")
    suspend  fun postbenef(
        @Path("id") id: Int?,
        @Body body: SpinnerModel?
    ): SpinnerModel?


    @GET("client/{id}")
    suspend  fun getMultitransfers(
        @Path("id") id: Int?
    ): List<MultiTransfer?>?

    @POST("createTransfer/{id}")
    suspend  fun postTransfer(
        @Path("id") id: Int?,
        @Body body: MultiTransfer?
    ): MultiTransfer?

    @GET("UniqueTransfer/{reference}/{id}")
    suspend  fun getTransfer(
        @Path("id") id: Int?,
        @Path("reference") reference: String?
    ): MultiTransfer?

    @POST("https://ensa-api-transfer.herokuapp.com/api_client/UniqueTransfer/return/{reference}/{id}")
    suspend fun putTransfer(
        @Path("id") id: Int?,
        @Path("reference") reference: String?,
        @Query("motif") motif: String?
    ): MultiTransfer?

}