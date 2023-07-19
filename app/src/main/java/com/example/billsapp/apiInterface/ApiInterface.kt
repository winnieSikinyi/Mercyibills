package com.example.billsapp.apiInterface

import android.media.MediaCodec.QueueRequest
import com.example.billsapp.models.RegisterRequest
import com.example.billsapp.models.RegisterResponse
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body regesterRequest: RegisterRequest): Response<RegisterResponse>
}