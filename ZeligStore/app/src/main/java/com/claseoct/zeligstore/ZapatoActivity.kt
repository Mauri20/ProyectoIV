package com.claseoct.zeligstore

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.documentfile.provider.DocumentFile
import com.claseoct.zeligstore.APISpring.UsersAPI
import com.claseoct.zeligstore.APISpring.ZapatosAPI
import com.claseoct.zeligstore.RequestClass.ZapatoRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

class ZapatoActivity : AppCompatActivity() {
    val REQUEST_GALLERY = 1
    private lateinit var image: ImageView
    private lateinit var modelo:EditText
    private lateinit var talla:EditText
    private lateinit var color:EditText
    private lateinit var precio:EditText
    private lateinit var spinCategoria:Spinner
    private lateinit var spinEstilo:Spinner
    private lateinit var spinMarca:Spinner
    //Listas a llenar con los id
    private lateinit var listaIdCategorias:ArrayList<String>
    private lateinit var listaIdEstilos:ArrayList<String>
    private lateinit var listaIdMarcas:ArrayList<String>
    //Listas a llenar con los nombres
    private lateinit var listaNomCategorias:ArrayList<String>
    private lateinit var listaNomEstilos:ArrayList<String>
    private lateinit var listaNomMarcas:ArrayList<String>
    //Variables que guardaran el id seleccionado
    var idCategoria="0"
    var idMarca="0"
    var idEstilo="0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zapato)
        image=findViewById(R.id.imageZapato)
        modelo=findViewById(R.id.et_Modelo)
        talla=findViewById(R.id.et_Talla)
        color=findViewById(R.id.et_Color)
        precio=findViewById(R.id.et_Precio)
        spinCategoria=findViewById(R.id.spinCategoria)
        spinEstilo=findViewById(R.id.spinEstilo)
        spinMarca=findViewById(R.id.spinMarca)

        //Asignando el id de la listaIdMarcas a la variable que lo guardara
        spinMarca.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                idMarca=listaIdMarcas.get(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        //Asignando el id de la listaIdCategorias a la variable que lo guardara
        spinCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                idCategoria=listaIdCategorias.get(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        //Asignando el id de la listaIdEstilos a la variable que lo guardara
        spinEstilo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                idEstilo=listaIdEstilos.get(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //Inicializando las listas
        listaIdCategorias= arrayListOf<String>("")
        listaIdEstilos=arrayListOf<String>("")
        listaIdMarcas=arrayListOf<String>("")

        listaNomCategorias= arrayListOf<String>("")
        listaNomEstilos= arrayListOf<String>("")
        listaNomMarcas= arrayListOf<String>("")

        //Con estos metodos se llenan las listas usando Retrofit
        mostrarCategorias()
        mostrarMarcas()
        mostrarEstilos()
    }
    //Funcion para mandar y recibir json a la API REST
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/ZeligStore/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //traer las categorias
    private fun mostrarCategorias(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                var call = getRetrofit().create(ZapatosAPI::class.java).showCategorias()
                val respuesta = call.body()?: emptyList()
                runOnUiThread{
                    if(call.isSuccessful){
                        listaIdCategorias.clear()
                        listaNomCategorias.clear()
                        for(i in respuesta){
                            listaIdCategorias.add(i.idcategoria.toString())
                            listaNomCategorias.add(i.nombrecat)
                        }
                        val adapter= ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,listaNomCategorias)
                        spinCategoria.adapter=adapter
                    }
                    else{
                        println("Error al traer las categorias")
                    }
                }
            }
        }catch (e: IOException){
            println(e)
        }
    }
    //traer las Marcas
    private fun mostrarMarcas(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                var call = getRetrofit().create(ZapatosAPI::class.java).showMarcas()
                val respuesta = call.body()?: emptyList()
                runOnUiThread{
                    if(call.isSuccessful){
                        listaIdMarcas.clear()
                        listaNomMarcas.clear()
                        for(i in respuesta){
                            listaIdMarcas.add(i.idmarca.toString())
                            listaNomMarcas.add(i.nombremar)
                        }
                        val adapter= ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,listaNomMarcas)
                        spinMarca.adapter=adapter
                    }
                    else{
                        println("Error al traer las Marcas")
                    }
                }
            }
        }catch (e: IOException){
            println(e)
        }
    }
    //traer los Estilos
    private fun mostrarEstilos(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                var call = getRetrofit().create(ZapatosAPI::class.java).showStyles()
                val respuesta = call.body()?: emptyList()
                runOnUiThread{
                    if(call.isSuccessful){
                        listaIdEstilos.clear()
                        listaNomEstilos.clear()
                        for(i in respuesta){
                            listaIdEstilos.add(i.idestilo.toString())
                            listaNomEstilos.add(i.nombreest)
                        }
                        val adapter= ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,listaNomEstilos)
                        spinEstilo.adapter=adapter
                    }
                    else{
                        println("Error al traer los Estilos")
                    }
                }
            }
        }catch (e: IOException){
            println(e)
        }
    }

    //Todo lo de la imagen
    fun cargarImagen(view: View?){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                val permisosArchivos = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permisosArchivos, REQUEST_GALLERY)
            }else{
                MuestraGaleria()
            }
        }else{
            MuestraGaleria()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_GALLERY ->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    MuestraGaleria()
                }else{
                    //Permiso no existe
                }
            }
        }
    }
    private fun MuestraGaleria() {
        val intentGaleria = Intent(Intent.ACTION_PICK)
        intentGaleria.type = "image/*"
        startActivityForResult(intentGaleria, REQUEST_GALLERY)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_GALLERY){
            image.setImageURI(data?.data)
            //var name=File(data?.data?.path).name
        }
    }

    //Funcion para enviar los datos
    fun saveShoes(view: View?){

        val bitmap = (image.drawable as BitmapDrawable).bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
        var foto = stream.toByteArray()
        if(!modelo.text.isEmpty() && !talla.text.isEmpty() && !color.text.isEmpty() && !precio.text.isEmpty()){
            var model=modelo.text.toString()
            var tall=talla.text.toString().toDouble()
            var colr=color.text.toString()
            var preci=precio.text.toString().toDouble()
            var zapato=ZapatoRequest(model,tall,colr,preci,foto, idCategoria.toString().toInt(),idMarca.toString().toInt(), idEstilo.toString().toInt())
            //Corrutina para guardar
            val dialogo =
                AlertDialog.Builder(this) // NombreDeTuActividad.this, o getActivity() si es dentro de un fragmento
                    .setPositiveButton("Registrar") { dialog, which ->
                        try {
                            CoroutineScope(Dispatchers.IO).launch {
                                val call = getRetrofit().create(ZapatosAPI::class.java).saveZapato(zapato)
                                var respuesta=call.body()
                                runOnUiThread{
                                    if(call.isSuccessful){
                                        if(respuesta!=null){
                                            image.setImageDrawable(resources.getDrawable(R.drawable.zapatoinit))
                                            modelo.text.clear()
                                            talla.text.clear()
                                            color.text.clear()
                                            precio.text.clear()
                                            mostrarCategorias()
                                            mostrarMarcas()
                                            mostrarEstilos()
                                            println("Hecho")
                                        }
                                    } else{
                                        println("Error en el call")
                                    }
                                }
                            }
                        }catch (e : Exception){
                            println(e)
                        }
                    }.setNegativeButton(
                        "Cancelar"
                    ) { dialog, which -> // Hicieron click en el botón negativo, no confirmaron
                        // Simplemente descartamos el diálogo
                        dialog.dismiss()
                    }
                    .setTitle("Confirmar") // El título
                    .setMessage("¿Estás seguro que deseas guardar ahora?") // El mensaje
                    .create() // No olvides llamar a Create, ¡pues eso crea el AlertDialog!
            dialogo.show();
        }else{
            Toast.makeText(this,"¡Debe completar todos los Campos!",Toast.LENGTH_LONG).show()
        }

    }

    override fun onBackPressed()
    {
        super.onBackPressed()
        val returnIntent = Intent(this, MenuActivity::class.java)
        startActivity(returnIntent)
        finish()
    }

}