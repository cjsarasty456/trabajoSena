package com.sena.cambioactividad


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_segunda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        var btnVolver=findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            volver()
        }
    }

    fun volver(){
        finish()
    }

}