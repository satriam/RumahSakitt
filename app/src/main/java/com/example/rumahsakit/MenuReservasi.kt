package com.example.rumahsakit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.restapi.APIClient
import com.example.rumahsakit.Model.ReservasiModel
import com.example.rumahsakit.Model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuReservasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_reservasi)
        reservasi()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuhistory,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.history->{
                val intent= Intent(this, HistoryReservasi::class.java)
                startActivity(intent)
                true
            }else->super.onOptionsItemSelected(item)
        }
    }
    private fun reservasi(){

        val etnama: EditText = findViewById(R.id.etnamares)
        val etjam: EditText = findViewById(R.id.etjam)
        val etdokter: EditText = findViewById(R.id.iddokter)

        val btnsave: Button = findViewById(R.id.button)

        btnsave.setOnClickListener {
            val apiClient = APIClient.create()
            val sendData = apiClient.tambahreservasi(
                etnama.text.toString(),
                etjam.text.toString(),
                etdokter.text.toString(),

                )
            if (etnama.text.toString().isEmpty()) {
                etnama.setError("nama Tidak boleh Kosong")
            }
            if (etjam.text.toString().isEmpty()) {
                etjam.setError("jam Tidak boleh Kosong")
            }
            if (etdokter.text.toString().isEmpty()) {
                etjam.setError("id_dokter Tidak boleh Kosong")
            }


            sendData.enqueue(object : Callback<ReservasiModel> {
                override fun onResponse(
                    call: Call<ReservasiModel>,
                    response: Response<ReservasiModel>
                ) {
                    val status_code = response.code()
                    Log.d("INPUT", sendData.toString())
                    if (response.isSuccessful) {
                        Toast.makeText(this@MenuReservasi, "Berhasil reservasi ", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

                override fun onFailure(call: Call<ReservasiModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }
}