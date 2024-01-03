package com.example.movilcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.movilcrud.controller.productoController
import com.example.movilcrud.model.productos


class agregarProductoActivity : AppCompatActivity() {

    //variables que almacenan los campos de la vista
    lateinit var txtNombre:EditText
    lateinit var txtDescripcion:EditText
    lateinit var txtCantidad:EditText
    lateinit var txtPrecio:EditText
    lateinit var txtLog:EditText

    lateinit var btnGuardar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_producto)
        //se asigna los campos de la vista a las variables
        txtNombre=findViewById(R.id.txtNombre)
        txtDescripcion=findViewById(R.id.txtDescripcion)
        txtCantidad=findViewById(R.id.txtCantidad)
        txtPrecio=findViewById(R.id.txtPrecio)
        txtLog=findViewById(R.id.txtLog)
        btnGuardar=findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener{
            enviarPeticion()
        }
    }

    //se crea un función para validar los campos
    //envíar la petición
    fun enviarPeticion(){
        //se procede a validar el formulario
        var valido=true
        //validación de requerido
        if(txtNombre.text.trim().length==0){
            //mensaje a mostrar
            txtNombre.setError("El campo es requerido")
            valido=false
        }
        if(txtDescripcion.text.length==0){
            txtDescripcion.setError("Ingrese la descripción")
            valido=false
        }
        //se agregan las validaciones faltantes

        if(valido){
            //se envía la petición
            var producto=productos(
                0,
                txtNombre.text.toString(),
                txtDescripcion.text.toString(),
                txtPrecio.text.toString().toDouble(),
                txtCantidad.text.toString().toInt()
            )
            var peticion=productoController()
            peticion.crearProducto(this,producto)

        }else{
            //se muestra un error
            Toast.makeText(
                this,
                "Verifique el formulario",+
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}