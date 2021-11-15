package com.claseoct.zeligstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    //Funcion para seleccionar una marca
    fun selectMarca(Vista: View){
        when(Vista.id){
            R.id.imgBtn_puma ->
            {
                Toast.makeText(this, "Has seleccionado PUMA", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,PumaActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
            }
            R.id.imgBtn_adidas ->
            {
                Toast.makeText(this, "Has seleccionado ADIDAS", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,AdidasActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
            }
            R.id.imgBtn_converse ->
            {
                Toast.makeText(this, "Has seleccionado CONVERSE", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,ConverseActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
            }
            R.id.imgBtn_nike ->
            {
                Toast.makeText(this, "Has seleccionado NIKE", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,NikeActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
            }
            R.id.imgBtn_reebok ->
            {
                Toast.makeText(this, "Has seleccionado REEBOK", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,ReebokActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
            }
            R.id.imgBtn_vans ->
            {
                Toast.makeText(this, "Has seleccionado VANS", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,VansActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right,android.R.anim.slide_out_right);
            }
        }
    }
}