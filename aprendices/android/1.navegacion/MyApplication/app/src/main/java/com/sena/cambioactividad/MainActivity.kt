package com.sena.cambioactividad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //definir el objeto de los botones
        var btnSegundaActividad:Button
        var btnTerceraActividad:Button
        //Asignar el valor o asociar con el objeto de la interfaz
        btnSegundaActividad=findViewById(R.id.btnSecondActivity)
        btnTerceraActividad=findViewById(R.id.btnCambioTercera)
        //definir el cuadro de texto
        var txtParametro=findViewById<EditText>(R.id.txtParametro)

        /*se crea la acción,
        Cuando se presiona el botón
         */
        btnSegundaActividad.setOnClickListener {
            //cambio de actividad
            //var intent(actividad actual,nueva actividad)
            var intent=
                Intent(this,secondActivity::class.java)
            //ejecutamos la actividad
            startActivity(intent)
        }

        btnTerceraActividad.setOnClickListener {
            var intent2=Intent(this,thirdActivity::class.java).apply {
                //se asignan los parametros para la tercera actividad
                //putExtra("nombre de la viriable","valor")
                putExtra("parametro",
                    txtParametro.text.toString())
            }
            startActivity(intent2)
        }
    }

}