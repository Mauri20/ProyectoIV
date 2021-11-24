package com.claseoct.zeligstore.Adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.claseoct.zeligstore.Models.ZapatosClass
import com.claseoct.zeligstore.R
import com.claseoct.zeligstore.databinding.ItemRebookBinding
import com.squareup.picasso.Picasso

class ReebookHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding=ItemRebookBinding.bind(view)
    fun bind(zapato:ZapatosClass){
        val convertToBytes:ByteArray=Base64.decode(zapato.url,Base64.URL_SAFE)
        var bitMap:Bitmap=BitmapFactory.decodeByteArray(convertToBytes,0,convertToBytes.size)
        binding.ivItemReebook.setImageBitmap(bitMap)
        binding.tvModelo.setText(zapato.idmodelo.nombremod)
        binding.tvTalla.setText(zapato.talla.toString())
        binding.tvEstilo.setText(zapato.idestilo.nombreest)
        binding.tvPrecio.setText(zapato.precio.toString())

    }
}