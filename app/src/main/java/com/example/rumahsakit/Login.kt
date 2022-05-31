package com.example.rumahsakit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.restapi.APIClient
import com.example.rumahsakit.Model.UserModel
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
     auth()
        }
    private fun auth(){
        val apiClient = APIClient.create()

        val etemail =findViewById<EditText>(R.id.etusername)
        val etpassword =findViewById<EditText>(R.id.etpassword)
        val btnlogin =findViewById<Button>(R.id.buttonLogin)
        val signup = findViewById<TextView>(R.id.tvsignup)

        signup.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }

        btnlogin.setOnClickListener{
            apiClient.login(
                etemail.text.toString(),
                etpassword.text.toString()
            ).enqueue(object : Callback<UserModel> {
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    val loginresponse =response.body()
                    if (loginresponse?.status==200 ) {

                        val intent = Intent(this@Login, Home::class.java).also {
                            it.flags =
                                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        }
                        startActivity(intent)
                    }
                    else {
                        Log.d("Debug", "")
                        Toast.makeText(this@Login, "Login failed!", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Toast.makeText(
                        this@Login,
                        t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
        }

    }
    }
