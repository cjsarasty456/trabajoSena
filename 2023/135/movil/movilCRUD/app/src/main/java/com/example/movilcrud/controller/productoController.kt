package com.example.movilcrud.controller

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.example.movilcrud.model.productos

class productoController {

    var urlBase="https://laminose-salutes.000webhostapp.com/"
    //var urlBase="http://10.192.94.221:9000/"
    //urlBase="http://dirección_del_servidor/"

    fun crearProducto(context: Context,producto:productos){
        var url=urlBase+"guardarProductoJson"
        try{
            //se crea la petición
            var queue=object :StringRequest(
                Request.Method.POST,
                url
            )
        }catch (error:Exception){
            //en caso que la petición falle
            Toast.makeText(
                context,
                "Error en la petición",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}