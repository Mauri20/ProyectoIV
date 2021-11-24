package com.claseoct.zeligstore.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claseoct.zeligstore.Models.ZapatosClass
import com.claseoct.zeligstore.R

class ReebookAdapter(private val listaZapatos: List<ZapatosClass>):RecyclerView.Adapter<ReebookHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReebookHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ReebookHolder(layoutInflater.inflate(R.layout.item_rebook,parent,false))
    }

    override fun onBindViewHolder(holder: ReebookHolder, position: Int) {
        val itemZapato=listaZapatos[position]
        holder.bind(itemZapato)
    }

    override fun getItemCount(): Int =listaZapatos.size

}