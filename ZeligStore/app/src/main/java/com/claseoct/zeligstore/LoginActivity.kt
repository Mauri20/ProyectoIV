package com.claseoct.zeligstore


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.claseoct.zeligstore.APISpring.UsersAPI
import com.claseoct.zeligstore.APISpring.ZapatosAPI
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.content.SharedPreferences




class LoginActivity : AppCompatActivity() {
    //Variables para SharedPreferences
    lateinit var userType:String
    //Preparando las variables
    private lateinit var etUser:EditText
    private lateinit var etPassword: EditText
    private lateinit var cargar : KProgressHUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Asignando los componentes a las variables
        etUser=findViewById(R.id.et_User)
        etPassword=findViewById(R.id.et_Password)

        cargar = KProgressHUD.create(this)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setLabel("Por favor espera")
            .setDetailsLabel("Verificando usuario")
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.5f)
        Mostrar()
    }



    //Funcion para mandar y recibir json a la API REST
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/ZeligStore/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Metodo solo para pruebas de conexion
    private fun Mostrar(){
        try {
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
        catch (e:Exception){
            Toast.makeText(this, "??Error interno del servidor!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun MostrarTipoUsuario(User:String, Pass:String){
        try {
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
        catch (e:Exception){
            Toast.makeText(this, "??Error interno del servidor!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun LogearTo(user:String, pass:String){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(UsersAPI::class.java).loginUser(user, pass)
                val call_type = getRetrofit().create(UsersAPI::class.java).returnTypeUser(user, pass)
                val respuesta = call.body()
                val respuesta_type = call_type.body()

                runOnUiThread{
                    if(call.isSuccessful){
                        if(respuesta == true){
                            println("=========> Bienvenido")

                            //Regresa al hilo anterior
                            runOnUiThread{
                                if(call_type.isSuccessful){
                                    if(respuesta_type != null){
                                        for (i in respuesta_type){
                                            //Ac?? es d??nde validamos con los datos, si el usuario es administrador(1) o usuario corriente(0)
                                            if(i.tipousuario==1){
                                                println("${i.nombre}, t?? eres administrador del sistema.")
                                                savePreferences(i.tipousuario.toString())
                                                MostrarTipoUsuario(user, pass)
                                                nextActivityMenu()


                                            }
                                            else if(i.tipousuario==0){
                                                println("${i.nombre}, t?? eres un usuario corriente.")
                                                savePreferences(i.tipousuario.toString())
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
                            cargar.dismiss()
                            finish()
                        }
                        else if(respuesta == false){
                            println("=========> Not FOUND")
                            getMessageFailed()
                        }
                    }
                }
            }
        }
        catch (e:Exception){
            Toast.makeText(this, "??Error interno del servidor!", Toast.LENGTH_SHORT).show()
        }
    }


    //Funcion para evaluar si hay registro de credenciales
    fun evalCredentials(view: View){
        var user = etUser.text.toString()
        var pass = etPassword.text.toString()

        if(user.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "??Por favor, completa todos los campos!", Toast.LENGTH_SHORT).show()
        }
        else{
            cargar.show()
            try {
                LogearTo(user, pass)
            }catch (e:Exception){

                Toast.makeText(this, "??Error al establecer la Conexi??n!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun savePreferences(userType:String){
        var preferences=getSharedPreferences("tipoUser", Context.MODE_PRIVATE)
        preferences.edit().clear().commit()
        var preferences2=getSharedPreferences("tipoUser", Context.MODE_PRIVATE)
        preferences2.edit().putString("tipo",userType).commit()
    }
    fun nextActivityMenu(){
        startActivity(Intent(this,MenuActivity::class.java))
        overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
    }

    fun getMessageFailed(){
        cargar.dismiss()
        etUser.requestFocus()
        etUser.setText("")
        etPassword.setText("")
        Toast.makeText(this, "??Usuario no encontrado, \nVerifica que hayas escrito bien tus credenciales!", Toast.LENGTH_LONG).show()
    }

    fun proximamente(view: View){
        Toast.makeText(this, "??Funci??n disponible pr??ximamente!", Toast.LENGTH_SHORT).show()
    }


    //Funcion para ir al Registro
    fun onLoginClick(view: View?) {
        startActivity(Intent(this,NewUserActivity::class.java))
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);

    }

}