package com.claseoct.zeligstore.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claseoct.zeligstore.Models.ZapatosClass
import com.claseoct.zeligstore.R

class PumaAdapter (private val listaZapatos: List<ZapatosClass>): RecyclerView.Adapter<PumaHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PumaHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return PumaHolder(layoutInflater.inflate(R.layout.item_puma,parent,false))
    }

    override fun onBindViewHolder(holder: PumaHolder, position: Int) {
        val itemZapato=listaZapatos[position]
        holder.bind(itemZapato)
    }

    override fun getItemCount(): Int =listaZapatos.size

}