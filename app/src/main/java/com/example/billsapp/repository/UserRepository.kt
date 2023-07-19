package com.example.billsapp.repository

import com.example.billsapp.api.ApiClient
import com.example.billsapp.apiInterface.ApiInterface
import com.example.billsapp.models.RegisterResponse
import com.example.billsapp.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class UserRepository {
    var client=ApiClient.buildClient(ApiInterface::class.java)
    suspend fun registerUser(RegisterRequest: RegisterRequest):
            Response<RegisterResponse> {
        return withContext(Dispatchers.IO){
            client.registerUser(RegisterRequest)
        }
    }
}