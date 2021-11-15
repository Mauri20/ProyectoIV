package com.claseoct.zeligstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.time.Duration
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    //Preparando las variables
    private lateinit var etUser:EditText
    private lateinit var etPassword: EditText
    //Datos de usuarios para el logueo
    var userOne= arrayOf("Mauricio","Mauri","7227-2324","1234")
    var userTwo= arrayOf("Fatima","Fati","7734-2445","1234")
    var userThree= arrayOf("Andres","Andres","7275-6724","1234")
    var userFour= arrayOf("Jasmin","Jas","7646-9824","1234")
    var userFive= arrayOf("Joshua","Josh","7765-2904","1234")
    //variable con los datos para inicio de sesion
    var credentials= arrayListOf(userOne,userTwo,userThree,userFour,userFive)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Asignando los componentes a las variables
        etUser=findViewById(R.id.et_User)
        etPassword=findViewById(R.id.et_Password)

        //Recogiendo datos del Intent
        val miIntent=intent.extras
        val name=miIntent?.getString("name").toString()
        val user=miIntent?.getString("user").toString()
        val phone=miIntent?.getString("phone").toString()
        val password=miIntent?.getString("pass").toString()
        if(name!="null"&&user!="null"&&phone!="null"&&password!="null"){
            val newUser= arrayOf(name,user,phone,password)
            credentials.add(newUser)
        }
        credentials.forEach { println(it.get(1)) }
    }
    //Funcion para evaluar si hay registro de credenciales
    fun evalCredentials(view: View){
        var result=false
        var contador=0
        credentials.forEach{
            result = etUser.text.toString().equals(it.get(1)) && etPassword.text.toString().equals(it.get(3))
            if (result) contador=1
        }
        if(contador==1){
            startActivity(Intent(this,MenuActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
            contador=0
        }else {
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_LONG).show()
        }
    }

    //Funcion para ir al Registro
    fun onLoginClick(view: View?) {
        startActivity(Intent(this,NewUserActivity::class.java))
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}