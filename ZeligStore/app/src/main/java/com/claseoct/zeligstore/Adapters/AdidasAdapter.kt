package com.claseoct.zeligstore.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claseoct.zeligstore.Models.ZapatosClass
import com.claseoct.zeligstore.R

class AdidasAdapter(private val listaZapatos: List<ZapatosClass>):RecyclerView.Adapter<AdidasHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdidasHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return AdidasHolder(layoutInflater.inflate(R.layout.item_adidas,parent,false))
    }

    override fun onBindViewHolder(holder: AdidasHolder, position: Int) {
        val itemZapato=listaZapatos[position]
        holder.bind(itemZapato)
    }

    override fun getItemCount(): Int =listaZapatos.size
}