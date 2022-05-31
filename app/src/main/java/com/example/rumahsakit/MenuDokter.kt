package com.example.rumahsakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.APIClient
import com.example.rumahsakit.Adapter.DokterAdapter
import com.example.rumahsakit.Model.DokterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuDokter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_dokter)
        getdokter()
    }
    private fun getdokter(){
        val listData = ArrayList<DokterModel>()
        val rvStudents: RecyclerView =findViewById(R.id.recycleviewDokter)
        rvStudents.setHasFixedSize(true)
        rvStudents.layoutManager= LinearLayoutManager(this)
        val apiClient = APIClient.create()

        val callData =apiClient.getdokter()
        callData.enqueue(object : Callback<ArrayList<DokterModel>> {
            override fun onResponse(
                call: Call<ArrayList<DokterModel>>,
                response: Response<ArrayList<DokterModel>>
            ) {
                val data = response.body()
                val status_code= response.code()

                data?.let { listData.addAll(it) }
                val adapterData = DokterAdapter(listData)
                rvStudents.adapter=adapterData
                Log.d("DATA",data.toString())
                Log.d("DATA",status_code.toString())
            }

            override fun onFailure(call: Call<ArrayList<DokterModel>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }

        })
    }
}