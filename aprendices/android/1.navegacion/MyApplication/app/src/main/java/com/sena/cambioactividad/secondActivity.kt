package com.sena.cambioactividad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var btnVolver=findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            //destruir la actividad
            finish()
        }
    }
}