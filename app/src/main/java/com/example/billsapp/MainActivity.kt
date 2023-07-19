package com.example.billsapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import com.example.billsapp.databinding.ActivityMainBinding
import com.example.billsapp.viewmodels.UserViewModels


class MainActivity : AppCompatActivity() {
    val userViewModel:UserViewModels by  viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnsignup.setOnClickListener {
            validateSignup() }

        userViewModel.regLiveData.observe(this) { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
        }

        userViewModel.errorLiveData.observe(this) { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()

        }


    }


    fun validateSignup() {
//        var error=false
        val firstname =binding.tilFirstname.textAlignment.toString()
        val lastname = binding.tilLastName.text.toString()


        val email = binding.tilemail.text.toString()
        val password = binding.tilPassword.text.toString()
        var error = false


        if (lastname.isBlank()) {
            binding.tilLastName.error = "Enter your username"
            error = true
        }
        if (firstname.isBlank()) {
            binding.tilFirstname.error = "Enter your username"
        }

        if (email.isBlank()) {
            binding.tilemail.error = "Enter your email"
            error = true
        }

        if (password.isBlank()) {
            binding.tilPassword.error = "enter your password"
            error = true
        }



    }

    fun clearErrors(){
        binding.tilFirstname.error=null
        binding.tilLastName.error=null
        binding.tilemail.error =null
        binding.tilPassword.error= null

    }
}
