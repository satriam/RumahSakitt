package com.example.rumahsakit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.restapi.APIClient
import com.example.rumahsakit.Model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registrasi()
    }


  private fun registrasi(){

        val etUsername: EditText = findViewById(R.id.editUsernameRegist)
        val etpassword: EditText = findViewById(R.id.editPassRegist)

        val btnsave: Button = findViewById(R.id.buttonRegist)

        btnsave.setOnClickListener {
            val apiClient = APIClient.create()
            val sendData = apiClient.tambah(
                etUsername.text.toString(),
                etpassword.text.toString(),

            )
            if (etUsername.text.toString().isEmpty()) {
                etUsername.setError("Username Tidak boleh Kosong")
            }
            if (etpassword.text.toString().isEmpty()) {
                etpassword.setError("password Tidak boleh Kosong")
            }

            sendData.enqueue(object : Callback<UserModel> {
                override fun onResponse(
                    call: Call<UserModel>,
                    response: Response<UserModel>
                ) {
                    val status_code = response.code()
                    Log.d("INPUT", sendData.toString())
                    if (response.isSuccessful) {
                        Toast.makeText(this@Register, "Berhasil register silahkan login", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }

}