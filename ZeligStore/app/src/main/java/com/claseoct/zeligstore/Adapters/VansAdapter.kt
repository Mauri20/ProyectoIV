package com.claseoct.zeligstore.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claseoct.zeligstore.Models.ZapatosClass
import com.claseoct.zeligstore.R

class VansAdapter(private val listaZapatos: List<ZapatosClass>):RecyclerView.Adapter<VansHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VansHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return VansHolder(layoutInflater.inflate(R.layout.item_vans,parent,false))
    }

    override fun onBindViewHolder(holder: VansHolder, position: Int) {
        val itemZapato=listaZapatos[position]
        holder.bind(itemZapato)
    }

    override fun getItemCount(): Int =listaZapatos.size
}