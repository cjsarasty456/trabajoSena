package com.sena.cambioactividad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class activityTres : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tres)

        var lblParametro=findViewById<TextView>(R.id.lblParametro)
        var texto=intent.getStringExtra("parametro")
        lblParametro.text=texto
        var btnVolver=findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            volver()
        }
    }

    fun volver(){
        finish()
    }
}