package com.example.rumahsakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.APIClient
import com.example.rumahsakit.Adapter.DokterAdapter
import com.example.rumahsakit.Adapter.ObatAdapter
import com.example.rumahsakit.Model.DokterModel
import com.example.rumahsakit.Model.ObatModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuObat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_obat)
        getobat()
    }
    private fun getobat(){
        val listData = ArrayList<ObatModel>()
        val rvStudents: RecyclerView =findViewById(R.id.recycleviewObat)
        rvStudents.setHasFixedSize(true)
        rvStudents.layoutManager= LinearLayoutManager(this)
        val apiClient = APIClient.create()

        val callData =apiClient.getobat()
        callData.enqueue(object : Callback<ArrayList<ObatModel>> {
            override fun onResponse(
                call: Call<ArrayList<ObatModel>>,
                response: Response<ArrayList<ObatModel>>
            ) {
                val data = response.body()
                val status_code= response.code()

                data?.let { listData.addAll(it) }
                val adapterData = ObatAdapter(listData)
                rvStudents.adapter=adapterData
                Log.d("DATA",data.toString())
                Log.d("DATA",status_code.toString())
            }

            override fun onFailure(call: Call<ArrayList<ObatModel>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }

        })
    }
}