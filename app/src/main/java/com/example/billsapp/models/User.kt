package com.example.billsapp.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("FirstName") var FirstName:String,
    @SerializedName("PhoneNumber") var PhoneNumber:String,
    @SerializedName("user_id") var user_id:String,
    @SerializedName("LastName") var LastName:String,
    val email:String

)
