package com.example.crudmovil.controller

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.crudmovil.config.config
import com.example.crudmovil.model.producto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.util.concurrent.CountDownLatch

class productoController{
    var config: config =config()
   private var url =config.urlBase+"controller/productosController.php"
    lateinit var producto: producto
    lateinit var ListaProductos:MutableList<producto>
    fun guardarProducto(context:Context?,id:Int,nombre:String,descripcion:String,precio:String,cantidad:String):String{
        var url=config.urlBase+"guardarProductoJson"
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
            var parametros = JSONObject ().apply {
//                    parametros.put("function", "guardarProducto")
                put("id", producto.id.toString())
                put("nombre", producto.nombre)
                put("descripcion", producto.descripcion)
                put("precio", producto.precio.toString())
                put("cantidad", producto.cantidad.toString())
                put("imagen", " ")
            }

            // Realizar la solicitud POST con parámetros
            val     request = JsonObjectRequest(
                Request.Method.POST, url, parametros,
                Response.Listener { response ->
                    // Manejar la respuesta del servidor (si es necesario)
                    var prueba=response
                },
                Response.ErrorListener { error ->
                    // Manejar el error (si ocurre)
                    var prueba=error.message
                }
            )

            // Agregar la solicitud a la cola de Volley
            val queue = Volley.newRequestQueue(context)
            queue.add(request)

        }catch (error:Exception){
            retorno=error.message.toString()
        }
        return retorno
    }

    suspend fun consultarListaProductos(context:Context?): MutableList<producto> {
        var url=config.urlBase+"listarjson"
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
                    parametros.put("filtro", "")
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

    suspend fun consultarProductoporId(context:Context?,producto_id:Int): producto {
        var url=config.urlBase+"consultarjson/${producto_id}"
        ListaProductos= mutableListOf<producto>()
        var producto=producto(0,"","","","","")
        try {
            val queue = Volley.newRequestQueue(context)
            var respuesta=""
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    var retorno="[${response}]"
                    val gson: Gson = Gson()
                    ListaProductos = gson.fromJson(
                        retorno,
                        object : TypeToken<MutableList<producto>>() {}.type
                    )
                    producto=ListaProductos[0]

                    Toast.makeText(
                       context,
                        "Se guardo correctamente: ${response}",
                        Toast.LENGTH_LONG
                   ).show()
                    respuesta=response

                }, Response.ErrorListener { error ->
                    Toast.makeText(
                       context,
                        "Error al guardar: ${error.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    respuesta=error.message.toString()

                }
            )
            queue.add(stringRequest)
            // Esperar a que la solicitud termine (forma segura)
            while (respuesta=="" && producto.id==0) {
                kotlinx.coroutines.delay(500) // Pausa de 100 ms
            }
        } catch (error: Exception) {
            println(error.message)
        }



        return producto
    }
}



