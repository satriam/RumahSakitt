package com.example.rumahsakit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btreservasi = findViewById<Button>(R.id.reservasi)
        val dokter = findViewById<Button>(R.id.dokter)
        val btpasien = findViewById<Button>(R.id.pasien)
        val obat = findViewById<Button>(R.id.obat)

        btreservasi.setOnClickListener{
            val intent= Intent(this, MenuReservasi::class.java)
            startActivity(intent)
        }
        dokter.setOnClickListener{
            val intent= Intent(this, MenuDokter::class.java)
            startActivity(intent)
        }
        btpasien.setOnClickListener{
            val intent= Intent(this, MenuPasien::class.java)
            startActivity(intent)
        }
        obat.setOnClickListener{
            val intent= Intent(this, MenuObat::class.java)
            startActivity(intent)
        }

        }
    }