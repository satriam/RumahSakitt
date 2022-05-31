package com.example.rumahsakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.APIClient
import com.example.rumahsakit.Adapter.ObatAdapter
import com.example.rumahsakit.Adapter.PasienAdapter
import com.example.rumahsakit.Model.ObatModel
import com.example.rumahsakit.Model.PasienModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuPasien : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_pasien)
        getpasien()
    }
    private fun getpasien(){
        val listData = ArrayList<PasienModel>()
        val rvStudents: RecyclerView =findViewById(R.id.recycleviewPasien)
        rvStudents.setHasFixedSize(true)
        rvStudents.layoutManager= LinearLayoutManager(this)
        val apiClient = APIClient.create()

        val callData =apiClient.getpasien()
        callData.enqueue(object : Callback<ArrayList<PasienModel>> {
            override fun onResponse(
                call: Call<ArrayList<PasienModel>>,
                response: Response<ArrayList<PasienModel>>
            ) {
                val data = response.body()
                val status_code= response.code()

                data?.let { listData.addAll(it) }
                val adapterData = PasienAdapter(listData)
                rvStudents.adapter=adapterData
                Log.d("DATA",data.toString())
                Log.d("DATA",status_code.toString())
            }

            override fun onFailure(call: Call<ArrayList<PasienModel>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }

        })
    }
}