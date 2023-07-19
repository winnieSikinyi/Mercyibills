package com.example.billsapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.billsapp.models.RegisterResponse
import com.example.billsapp.models.RegisterRequest
import com.example.billsapp.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModels:ViewModel() {
    val regLiveData=MutableLiveData<RegisterResponse>()
    val errorLiveData=MutableLiveData<String>()
    val  userRepository=UserRepository()


    fun registerUser(regesterRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.registerUser(regesterRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}