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

class NewUserActivity : AppCompatActivity() {
    //Creando las variables para los objetos
    private lateinit var etName:EditText
    private lateinit var etUser:EditText
    private lateinit var etPhone:EditText
    private lateinit var etPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)
        //Asignando los objetos a las variables
        etName=findViewById(R.id.et_Name)
        etUser=findViewById(R.id.et_User)
        etPhone=findViewById(R.id.et_Phone)
        etPassword=findViewById(R.id.et_Password)
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

    //Funcion para guardar
    fun saveUser(view: View?){
        //variables contenedoras del texto de los campos
        var name=etName.text.toString()
        var user=etUser.text.toString()
        var phone=etPhone.text.toString()
        var password=etPassword.text.toString()
        //Evaluando si estan vacias
        if (!name.isEmpty()&&!user.isEmpty()&&!phone.isEmpty()&&!password.isEmpty()){
            var newUser2= arrayOf(name,user,phone,password)

            Toast.makeText(this,"Usuario Registrado",Toast.LENGTH_LONG).show()
            val inten=Intent(this,LoginActivity::class.java)
            inten.putExtra("name",name)
            inten.putExtra("user",user)
            inten.putExtra("phone",phone)
            inten.putExtra("pass",password)

            //Aca estamos haciendo uso del consumo de una API montada en un servidor remoto
            //===============================================================================
            val user:UsersClass = UsersClass(null, name, phone, user, password)
            GuardarNuevo(user)
            //===============================================================================

            startActivity(inten)
        }else{
            Toast.makeText(this,"Debe completar los campos",Toast.LENGTH_LONG).show()
        }
    }

    //Funcion para regresar a la vista anterior
    fun onLoginClick(view: View?) {
        startActivity(Intent(this,LoginActivity::class.java))
        overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
    }
}