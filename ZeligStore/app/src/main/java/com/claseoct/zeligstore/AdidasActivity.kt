package com.claseoct.zeligstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AdidasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adidas)
    }
    override fun onBackPressed()
    {
        super.onBackPressed()
        val returnIntent = Intent(this, MenuActivity::class.java)
        startActivity(returnIntent)
        finish()
    }
}