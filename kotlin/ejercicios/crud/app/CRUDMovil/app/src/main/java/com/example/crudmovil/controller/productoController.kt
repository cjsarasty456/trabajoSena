package com.example.crudmovil.controller

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.crudmovil.config.config
import com.example.crudmovil.model.producto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.lang.Exception
import java.util.concurrent.CountDownLatch

class productoController{
    var config: config =config()
   private var url =config.urlBase+"controller/productosController.php"
    lateinit var producto: producto
    lateinit var ListaProductos:MutableList<producto>
    fun guardarProducto(context:Context?,id:Int,nombre:String,descripcion:String,precio:String,cantidad:String):String{
        var retorno="";
        try {
            producto=producto(
                id,
                nombre,
                descripcion,
                precio,
                cantidad,
                ""
            )
            // Parámetros de la solicitud POST


            // Realizar la solicitud POST con parámetros
            val request = object : StringRequest(Request.Method.POST, url,
                Response.Listener<String> { response ->
                    // Procesar la respuesta String
                    val result = response
                    // Aquí puedes manejar la respuesta como desees
                },
                Response.ErrorListener { error ->
                    // Manejar errores de la solicitud
                    val errorMessage = error.message
                }) {
                // Agregar los parámetros a la solicitud
                override fun getParams(): Map<String, String> {
                    var
                            parametros = HashMap<String, String>()
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

            // Agregar la solicitud a la cola de Volley
            val queue = Volley.newRequestQueue(context)
            queue.add(request)

        }catch (error:Exception){
            retorno=error.message.toString()
        }
        return retorno
    }

    suspend fun consultarListaProductos(context:Context?): MutableList<producto> {
        ListaProductos= mutableListOf<producto>()
        try {
            val queue = Volley.newRequestQueue(context)
            var respuesta=""
            val stringRequest = object : StringRequest(
                Request.Method.POST, url,
                Response.Listener<String> { response ->
//                txtLog.setText(" ${txtLog.text.toString()}, ${response} ")
                    val gson: Gson = Gson()
                    ListaProductos = gson.fromJson(
                        response,
                        object : TypeToken<MutableList<producto>>() {}.type
                    )

//                    Toast.makeText(
//                        context,
//                        "Se guardo correctamente: ${response}",
//                        Toast.LENGTH_LONG
//                    ).show()
                    respuesta=response
//                    Toast.makeText(context, "Error al guardar: ${error.message}",Toast.LENGTH_LONG).show()
                }, Response.ErrorListener { error ->
//                    Toast.makeText(
//                        context,
//                        "Error al guardar: ${error.message}",
//                        Toast.LENGTH_LONG
//                    ).show()
                    respuesta=error.message.toString()

                }
            ) {
                override fun getParams(): MutableMap<String, String> {

                    val parametros = HashMap<String, String>()
                    parametros.put("function", "consultarListaProductos")
                    return parametros
                }
            }
            queue.add(stringRequest)
            // Esperar a que la solicitud termine (forma segura)
            while (respuesta=="" && ListaProductos.size==0) {
                kotlinx.coroutines.delay(500) // Pausa de 100 ms
            }
        } catch (error: Exception) {
            println(error.message)
        }



        return ListaProductos
    }
}



