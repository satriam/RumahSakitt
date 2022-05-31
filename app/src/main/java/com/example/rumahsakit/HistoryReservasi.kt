package com.example.rumahsakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.APIClient
import com.example.rumahsakit.Adapter.ObatAdapter
import com.example.rumahsakit.Adapter.ReservasiAdapter
import com.example.rumahsakit.Model.ObatModel
import com.example.rumahsakit.Model.ReservasiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryReservasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_reservasi)
        historyreservasi()
    }
    private fun historyreservasi(){
        val listData = ArrayList<ReservasiModel>()
        val rvStudents: RecyclerView =findViewById(R.id.recycleviewreservasi)
        rvStudents.setHasFixedSize(true)
        rvStudents.layoutManager= LinearLayoutManager(this)
        val apiClient = APIClient.create()

        val callData =apiClient.getreservasi()
        callData.enqueue(object : Callback<ArrayList<ReservasiModel>> {
            override fun onResponse(
                call: Call<ArrayList<ReservasiModel>>,
                response: Response<ArrayList<ReservasiModel>>
            ) {
                val data = response.body()
                val status_code= response.code()

                data?.let { listData.addAll(it) }
                val adapterData = ReservasiAdapter(listData)
                rvStudents.adapter=adapterData
                Log.d("DATA",data.toString())
                Log.d("DATA",status_code.toString())
            }

            override fun onFailure(call: Call<ArrayList<ReservasiModel>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }

        })
    }
}