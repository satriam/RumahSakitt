package com.example.rumahsakit.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rumahsakit.Model.ObatModel
import com.example.rumahsakit.R

class ObatAdapter(private val dataList: ArrayList<ObatModel>):RecyclerView.Adapter<ObatAdapter.ViewHolderData>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ObatAdapter.ViewHolderData {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.rv_obat,parent,false)

        return ViewHolderData(layout)
    }

    override fun onBindViewHolder(holder: ObatAdapter.ViewHolderData, position: Int) {
        val item=dataList[position]

        holder.nama.text=item.obat
        holder.jenis.text=item.deskripsi
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolderData(itemView: View):RecyclerView.ViewHolder(itemView) {


        val nama: TextView= itemView.findViewById(R.id.tv_obat)
        val jenis: TextView= itemView.findViewById(R.id.tv_jenis)
        val context = itemView.context
    }
}