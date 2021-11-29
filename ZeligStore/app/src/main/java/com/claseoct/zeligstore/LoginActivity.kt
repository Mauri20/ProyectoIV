package com.claseoct.zeligstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.claseoct.zeligstore.APISpring.UsersAPI
import com.claseoct.zeligstore.APISpring.ZapatosAPI
import com.claseoct.zeligstore.Models.UsersClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import java.time.Duration
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    //Preparando las variables
    private lateinit var etUser:EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Asignando los componentes a las variables
        etUser=findViewById(R.id.et_User)
        etPassword=findViewById(R.id.et_Password)
    }



    //Funcion para mandar y recibir json a la API REST
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/ZeligStore/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun Mostrar(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ZapatosAPI::class.java).showAllShoes2("Zapatos/showAllZapatos/Reebook")
            val respuesta = call.body()?: emptyList()

            runOnUiThread{
                if(call.isSuccessful){
                    for(i in respuesta){
                        println("Modelo: " + i.idmodelo.nombremod)
                        println("Marca: " + i.idmodelo.idmarca.nombremar)
                        println("Precio: " + i.precio)
                        println("Talla: " + i.talla)
                        println("-------------------")
                    }
                }
                else{
                    println("Error al traer los datos")
                }
            }
        }
    }

    private fun MostrarTipoUsuario(User:String, Pass:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(UsersAPI::class.java).returnTypeUser(User, Pass)
            val respuesta = call.body()

            runOnUiThread{
                if(call.isSuccessful){
                    if (respuesta != null) {
                        for (i in respuesta){
                            println("=> Nombre de Usuario: " + i.usuario)
                            println("=> Tipo Usuario: " + i.tipousuario)
                        }
                    }
                }
            }
        }
    }

    private fun LogearTo(user:String, pass:String){

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(UsersAPI::class.java).loginUser(user, pass)
            val call_type = getRetrofit().create(UsersAPI::class.java).returnTypeUser(user, pass)
            val respuesta = call.body()
            val respuesta_type = call_type.body()

            runOnUiThread{
                if(call.isSuccessful){
                    if(respuesta == true){
                        println("=========> Bienvenido")

                        runOnUiThread{
                            if(call_type.isSuccessful){
                                if(respuesta_type != null){
                                    for (i in respuesta_type){
                                        //Acá es dónde validamos con los datos, si el usuario es administrador(1) o usuario corriente(0)
                                        if(i.tipousuario==1){
                                            println("${i.nombre}, tú eres administrador del sistema.")
                                            MostrarTipoUsuario(user, pass)
                                            nextActivityMenu()
                                        }
                                        else if(i.tipousuario==0){
                                            println("${i.nombre}, tú eres un usuario corriente.")
                                            MostrarTipoUsuario(user, pass)
                                            nextActivityMenu()
                                        }
                                        else if(i.tipousuario==null){
                                            println("Ha ocurrido un error inesperado!!")
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(respuesta == false){
                        println("=========> Not FOUND")
                        getMessageFailed()
                    }
                }
            }
        }
    }

    //Funcion para evaluar si hay registro de credenciales
    fun evalCredentials(view: View){

        var user = etUser.text.toString()
        var pass = etPassword.text.toString()

        if(user.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "¡Por favor, completa todos los campos!", Toast.LENGTH_SHORT).show()
        }
        else{
            try {
                LogearTo(user, pass)
                etUser.text = null
                etPassword.text = null
            }catch (e:Exception){
                Toast.makeText(this, "¡Error al establecer la Conexión!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun nextActivityMenu(){
        startActivity(Intent(this,MenuActivity::class.java))
        overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
    }

    fun getMessageFailed(){
        Toast.makeText(this, "¡Usuario no encontrado, \nVerifica que hayas escrito bien tus credenciales!", Toast.LENGTH_LONG).show()
    }


    //Funcion para ir al Registro
    fun onLoginClick(view: View?) {
        startActivity(Intent(this,NewUserActivity::class.java))
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}