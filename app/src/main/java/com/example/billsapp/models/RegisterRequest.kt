package com.example.billsapp.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("FirstName") var FirstName:String,
    @SerializedName("LastName") var LastName:String,
    var email:String,
    var PassWord:String,
    @SerializedName("PhoneNumber") var PhoneNumber:String,

)
