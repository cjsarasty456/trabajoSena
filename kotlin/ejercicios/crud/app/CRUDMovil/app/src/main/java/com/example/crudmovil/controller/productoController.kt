package com.example.crudmovil.controller

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.crudmovil.model.producto
import java.lang.Exception

class productoController{

   private var url ="https://laminose-salutes.000webhostapp.com/controller/productosController.php"
    lateinit var producto: producto
    fun guardarProducto(context:Context?,id:Int,nombre:String,descripcion:String,precio:String,cantidad:String):String{
        try {
            producto(
                id,
                nombre,
                descripcion,
                precio,
                cantidad,
                ""
            )
            var retorno: String = ""
            val queue = Volley.newRequestQueue(context)
            val stringRequest = object : StringRequest(
                Request.Method.POST, url,
                Response.Listener<String> { response ->
//                txtLog.setText(" ${txtLog.text.toString()}, ${response} ")
                    Toast.makeText(context, "Se guardo correctamente: ${response}",Toast.LENGTH_LONG).show()
//                    Toast.makeText(context, "Error al guardar: ${error.message}",Toast.LENGTH_LONG).show()
                }, Response.ErrorListener { error ->
                    Toast.makeText(context, "Error al guardar: ${error.message}",Toast.LENGTH_LONG).show()

                }
            ) {
                override fun getParams(): MutableMap<String, String> {

                    val parametros = HashMap<String, String>()
                    parametros.put("function", "guardarProducto")
                    parametros.put("id", producto.id.toString())
                    parametros.put("nombre", producto.nombre)
                    parametros.put("descripcion", producto.descripcion)
                    parametros.put("precio", producto.precio.toString())
                    parametros.put("cantidad", producto.cantidad.toString())
                    parametros.put("imagen", " ")
                    return parametros
                }
            }
            queue.add(stringRequest)
            return retorno
        }catch (error:Exception){
            println(error.message)
            return ""
        }
    }

}
