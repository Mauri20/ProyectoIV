package com.claseoct.zeligstore.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claseoct.zeligstore.Models.ZapatosClass
import com.claseoct.zeligstore.R

class NikeAdapter(private val listaZapatos: List<ZapatosClass>): RecyclerView.Adapter<NikeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NikeHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return NikeHolder(layoutInflater.inflate(R.layout.item_nike,parent,false))
    }

    override fun onBindViewHolder(holder: NikeHolder, position: Int) {
        val itemZapato=listaZapatos[position]
        holder.bind(itemZapato)
    }

    override fun getItemCount(): Int =listaZapatos.size
}