package com.claseoct.zeligstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.claseoct.zeligstore.APISpring.ZapatosAPI
import com.claseoct.zeligstore.Adapters.ReebookAdapter
import com.claseoct.zeligstore.Models.ZapatosClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReebokActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var recycler:RecyclerView
    //variable que trae los datos
    private lateinit var call:Response<List<ZapatosClass>>
    //adaptador para el cecycler
    private lateinit var adapterRecycler:ReebookAdapter
    //Lista vacia para inicial el Recycler
    private val listaZapatos= mutableListOf<ZapatosClass>()

    var marca="Reebook"
    var categoria="Todos"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reebok)
        spinner=findViewById(R.id.sp_Catego)
        recycler=findViewById(R.id.cv_reebook)

        val categorias= arrayOf("Todos","Mujer","Hombre","Niña","Niño")
        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,categorias)
        spinner.adapter=adapter
        onClickItem()
        iniciarRecyclerView()
        mostrarZapatos(marca,categoria)
        //No me deja reinstalar la app
    }
    private fun iniciarRecyclerView(){
        recycler.layoutManager=LinearLayoutManager(this)
        adapterRecycler= ReebookAdapter(listaZapatos)
        recycler.adapter=adapterRecycler
    }
    fun onClickItem(){
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                println(position.toString())
                if(position==1){
                    categoria="Mujer"
                }else if(position==2){
                    categoria="Hombre"
                }else if(position==3){
                    categoria="Niña"
                }else if(position==4){
                    categoria="Niño"
                }else{
                    categoria="Todos"
                }
                mostrarZapatos(marca,categoria)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Nada fue seleccionado. Por cierto, no he visto que este método se desencadene
            }
        }
    }
    //Funcion para mandar y recibir json a la API REST
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/ZeligStore/Zapatos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun mostrarZapatos(marca:String,categoria:String){
        CoroutineScope(Dispatchers.IO).launch {

            if(categoria.equals("Todos")){
                call = getRetrofit().create(ZapatosAPI::class.java).showAllShoes2("showAllZapatos/$marca")
            }else{
                call = getRetrofit().create(ZapatosAPI::class.java).showAllShoes2("showAllZapatosByCategory/$categoria/$marca")
            }
            val respuesta = call.body()?: emptyList()

            runOnUiThread{
                if(call.isSuccessful){
                    for(i in respuesta){
                        println("Modelo: " + i.idmodelo.nombremod)
                        println("Marca: " + i.idmodelo.idmarca.nombremar)
                        println("Precio: " + i.precio)
                        println("Talla: " + i.talla)
                        println("-------------------")
                        listaZapatos.clear()
                        listaZapatos.addAll(respuesta)
                        adapterRecycler.notifyDataSetChanged()
                        iniciarRecyclerView()
                    }
                }
                else{
                    println("Error al traer los datos")
                }
            }
        }
    }

}