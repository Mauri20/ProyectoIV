package com.claseoct.zeligstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class ZapatoActivity : AppCompatActivity() {
    private lateinit var spinCategoria:Spinner
    private lateinit var spinEstilo:Spinner
    private lateinit var spinMarca:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zapato)
        spinCategoria=findViewById(R.id.spinCategoria)
        spinEstilo=findViewById(R.id.spinEstilo)
        spinMarca=findViewById(R.id.spinMarca)
        val categorias= arrayOf("Categorias","Mujer","Hombre","Niña","Niño")
        val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,categorias)
        spinCategoria.adapter=adapter
        val estilos= arrayOf("EStilos","Mujer","Hombre","Niña","Niño")
        val adapter2= ArrayAdapter(this,android.R.layout.simple_spinner_item,estilos)
        spinEstilo.adapter=adapter2
        val marcas= arrayOf("Marcas","Mujer","Hombre","Niña","Niño")
        val adapter3= ArrayAdapter(this,android.R.layout.simple_spinner_item,marcas)
        spinEstilo.adapter=adapter3
    }
}