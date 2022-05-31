package com.example.rumahsakit.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rumahsakit.Model.DokterModel
import com.example.rumahsakit.R

class DokterAdapter(private val dataList: ArrayList<DokterModel>):RecyclerView.Adapter<DokterAdapter.ViewHolderData>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DokterAdapter.ViewHolderData {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.rv_dokter,parent,false)

        return ViewHolderData(layout)
    }

    override fun onBindViewHolder(holder: DokterAdapter.ViewHolderData, position: Int) {
        val item=dataList[position]
        holder.id.text= item.id.toString()
        holder.nama.text=item.nama
        holder.jam.text=item.jam
        holder.spesialis.text=item.jenis

    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolderData(itemView: View):RecyclerView.ViewHolder(itemView) {

        val id: TextView= itemView.findViewById(R.id.tv_id)
        val nama: TextView= itemView.findViewById(R.id.tv_nama)
        val jam: TextView= itemView.findViewById(R.id.tv_jam)
        val spesialis: TextView= itemView.findViewById(R.id.tv_Spesialis)
        val context = itemView.context
    }
}