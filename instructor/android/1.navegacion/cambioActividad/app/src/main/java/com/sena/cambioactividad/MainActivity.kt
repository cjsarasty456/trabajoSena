package com.sena.cambioactividad

//Importar las librerías necesarias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var txtParametro:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnCambioActividad=findViewById<Button>(R.id.btnCambioActividad)
        var btnTerceraActividad=findViewById<Button>(R.id.btnTerceraActividad)
        txtParametro=findViewById<EditText>(R.id.txtParametro)

        btnCambioActividad.setOnClickListener {
            cambioActividadSinParametro()
        }
        btnTerceraActividad.setOnClickListener {
            cambioActividadParametro()
        }

    }
    fun cambioActividadSinParametro(){
        var intent= Intent(this,activity_segunda::class.java)
        startActivity(intent)
    }

    fun cambioActividadParametro(){
        var intent2=Intent(this,activityTres::class.java).apply {
            putExtra("parametro",txtParametro.text.toString())
        }
        startActivity(intent2)
    }
}