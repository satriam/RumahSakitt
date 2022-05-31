package com.example.rumahsakit.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rumahsakit.Model.ObatModel
import com.example.rumahsakit.Model.ReservasiModel
import com.example.rumahsakit.R

class ReservasiAdapter(private val dataList: ArrayList<ReservasiModel>):RecyclerView.Adapter<ReservasiAdapter.ViewHolderData>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReservasiAdapter.ViewHolderData {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.rv_reservasi,parent,false)

        return ViewHolderData(layout)
    }

    override fun onBindViewHolder(holder: ReservasiAdapter.ViewHolderData, position: Int) {
        val item=dataList[position]

        holder.nama.text=item.nama
        holder.jam.text=item.jam
        holder.dokter.text= item.id_dokter.toString()
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolderData(itemView: View):RecyclerView.ViewHolder(itemView) {


        val nama: TextView= itemView.findViewById(R.id.tv_pasien)
        val jam: TextView= itemView.findViewById(R.id.tv_jam)
        val dokter: TextView= itemView.findViewById(R.id.tv_Dokter)
        val context = itemView.context
    }
}