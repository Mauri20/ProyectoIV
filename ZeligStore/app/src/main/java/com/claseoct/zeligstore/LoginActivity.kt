package com.claseoct.zeligstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        Mostrar()
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
            val call = getRetrofit().create(ZapatosAPI::class.java).showAllShoes()
            val respuesta = call.body()?: emptyList()

            runOnUiThread{
                if(call.isSuccessful){
                    for(i in respuesta){
                        println("Nombre: " + i.idzapato)
                    }
                }
            }
        }
    }

    private fun LogearTo(user:String, pass:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(UsersAPI::class.java).loginUser(user, pass)
            val respuesta = call.body()

            runOnUiThread{
                if(call.isSuccessful){
                    if(respuesta == true){
                        println("=========> Bienvenido")
                        nextActivityMenu()
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
            LogearTo(user, pass)
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