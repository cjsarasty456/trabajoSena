package com.sena.cambioactividad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class thirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        var lblParametro=findViewById<TextView>(R.id.lblParametro)
        var parametro=intent.
        getStringExtra("parametro").toString()
        lblParametro.setText(parametro)
    }
}