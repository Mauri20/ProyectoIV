package com.claseoct.zeligstore.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claseoct.zeligstore.Models.ZapatosClass
import com.claseoct.zeligstore.R

class ConverseAdapter(private val listaZapatos: List<ZapatosClass>): RecyclerView.Adapter<ConverseHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverseHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ConverseHolder(layoutInflater.inflate(R.layout.item_converse,parent,false))
    }

    override fun onBindViewHolder(holder: ConverseHolder, position: Int) {
        val itemZapato=listaZapatos[position]
        holder.bind(itemZapato)
    }

    override fun getItemCount(): Int =listaZapatos.size
}