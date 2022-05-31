package com.example.rumahsakit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rumahsakit.Model.ObatModel
import com.example.rumahsakit.Model.PasienModel
import com.example.rumahsakit.R

class PasienAdapter(private val dataList: ArrayList<PasienModel>): RecyclerView.Adapter<PasienAdapter.ViewHolderData>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PasienAdapter.ViewHolderData {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.rv_pasien,parent,false)

        return ViewHolderData(layout)
    }

    override fun onBindViewHolder(holder: PasienAdapter.ViewHolderData, position: Int) {
        val item=dataList[position]
        holder.nama.text=item.pasien
        holder.kamar.text=item.kamar
        holder.status.text=item.status
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolderData(itemView: View): RecyclerView.ViewHolder(itemView) {


        val nama: TextView = itemView.findViewById(R.id.tv_pasien)
        val status: TextView = itemView.findViewById(R.id.tv_status)
        val kamar: TextView = itemView.findViewById(R.id.tv_kamar)
        val context = itemView.context
    }
}