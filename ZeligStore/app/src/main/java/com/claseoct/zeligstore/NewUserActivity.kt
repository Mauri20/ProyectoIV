package com.claseoct.zeligstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.claseoct.zeligstore.APISpring.UsersAPI
import com.claseoct.zeligstore.Models.UsersClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater
import android.widget.CheckBox


class NewUserActivity : AppCompatActivity() {
    //Creando las variables para los objetos
    private lateinit var etName:EditText
    private lateinit var etUser:EditText
    private lateinit var etPhone:EditText
    private lateinit var etPassword:EditText
    private lateinit var chbx_admin:CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)
        //Asignando los objetos a las variables
        etName=findViewById(R.id.et_Name)
        etUser=findViewById(R.id.et_User)
        etPhone=findViewById(R.id.et_Phone)
        etPassword=findViewById(R.id.et_Password)
        chbx_admin=findViewById(R.id.chbx_admin)
    }
    //Funcion para mandar y recibir json a la API REST
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/ZeligStore/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun GuardarNuevo(user:UsersClass){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(UsersAPI::class.java).nuevoRegistro(user)
        }
    }

    private fun VerifyTo(user:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(UsersAPI::class.java).verifyUser(user)
            val respuesta = call.body()

            runOnUiThread{
                if(call.isSuccessful){
                    if(respuesta == true){
                        println("=========> USUARIO ENCONTRADO")
                        getMessageFailed()
                    }
                    else if(respuesta == false){
                        println("=========> Not FOUND")

                    }
                }
            }
        }
    }

    fun getMessageFailed(){
        Toast.makeText(this, "¡El usuario que está tratando de ingresar ya existe, por favor intente con otro!", Toast.LENGTH_LONG).show()
    }

    fun getMessageFailedPin(){
        Toast.makeText(this, "¡PIN INCORRECTO!", Toast.LENGTH_LONG).show()
    }

    fun getMessageSuccesfully(){
        Toast.makeText(this,"¡Has sido registrado con éxito!",Toast.LENGTH_LONG).show()
    }

    fun getRedirectLoginActivity(){
        val inten=Intent(this,LoginActivity::class.java)
        startActivity(inten)
    }

    //Funcion para guardar
    fun saveUser(view: View?){
        //variables contenedoras del texto de los campos
        var name=etName.text.toString()
        var user=etUser.text.toString()
        var phone=etPhone.text.toString()
        var password=etPassword.text.toString()
        var admin = 0;
        val accessPin = 12345

        //Evaluando si estan vacias
        if (!name.isEmpty()&&!user.isEmpty()&&!phone.isEmpty()&&!password.isEmpty()){
            val dialogo =
                AlertDialog.Builder(this) // NombreDeTuActividad.this, o getActivity() si es dentro de un fragmento
                    .setPositiveButton("Registrame") { dialog, which ->
                        CoroutineScope(Dispatchers.IO).launch {
                            val call = getRetrofit().create(UsersAPI::class.java).verifyUser(user)
                            val respuesta = call.body()

                            runOnUiThread{
                                if(call.isSuccessful){
                                    if(respuesta == true){
                                        println("=========> USUARIO ENCONTRADO")
                                        getMessageFailed()
                                    }
                                    else if(respuesta == false){
                                        println("=========> Not FOUND")
                                        if(chbx_admin.isChecked){
                                            admin = 1

                                            val builder = AlertDialog.Builder(this@NewUserActivity)
                                            val inflater:LayoutInflater = layoutInflater
                                            val dialogLayout:View = inflater.inflate(R.layout.edittext_dialog, null)
                                            val editText:EditText = dialogLayout.findViewById<EditText>(R.id.et_securepin)
                                            
                                            with(builder){
                                                setTitle("¡Código de acceso necesario!")
                                                setPositiveButton("Verificar"){dialog, which->

                                                    var pin = editText.text.toString().toInt()

                                                    if(pin == accessPin){
                                                        //Aca estamos haciendo uso del consumo de una API montada en un servidor remoto
                                                        //===============================================================================
                                                        val user:UsersClass = UsersClass(null, name, phone, user, password, admin)
                                                        GuardarNuevo(user)
                                                        //===============================================================================
                                                        getMessageSuccesfully()
                                                        getRedirectLoginActivity()
                                                    }
                                                    else{
                                                        getMessageFailedPin()
                                                    }
                                                }
                                                setNegativeButton("Cancelar"){dialog, which->
                                                    dialog.dismiss()
                                                }
                                                setView(dialogLayout)
                                                show()
                                            }
                                        }
                                        else{
                                            admin = 0

                                            //Aca estamos haciendo uso del consumo de una API montada en un servidor remoto
                                            //===============================================================================
                                            val user:UsersClass = UsersClass(null, name, phone, user, password, admin)
                                            GuardarNuevo(user)
                                            //===============================================================================
                                            getMessageSuccesfully()
                                            getRedirectLoginActivity()
                                        }
                                    }
                                }
                            }
                        }
                    }
                    .setNegativeButton(
                        "Cancelar"
                    ) { dialog, which -> // Hicieron click en el botón negativo, no confirmaron
                        // Simplemente descartamos el diálogo
                        dialog.dismiss()
                    }
                    .setTitle("Confirmar") // El título
                    .setMessage("¿Estas seguro que deseas registrarte ahora?") // El mensaje
                    .create() // No olvides llamar a Create, ¡pues eso crea el AlertDialog!
            dialogo.show();
        }else{
            Toast.makeText(this,"¡Por favor, completa todos los campos!",Toast.LENGTH_LONG).show()
        }
    }

    //Funcion para regresar a la vista anterior
    fun onLoginClick(view: View?) {
        startActivity(Intent(this,LoginActivity::class.java))
        overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
    }
}