package com.example.movilcrud.controller

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.movilcrud.model.productos
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class productoController {

    //var urlBase="https://laminose-salutes.000webhostapp.com/"
    //var urlBase="http://10.192.94.221/"
    //urlBase="http://dirección_del_servidor/"
    //var url=urlBase+"controller/productosController.php"

    var urlBase="http://192.168.137.1:9000/"
    fun crearProducto(context: Context,producto:productos){
        var url=urlBase+"guardarProductoJson"
        try{
            //se crea la petición
            val request = object : StringRequest(
                Request.Method.POST,
                url,
                Response.Listener<String> { response ->
                    // Procesar la respuesta String
                    val result = response
                    // Aquí puedes manejar la respuesta como desees
                    Toast.makeText(
                        context,
                        response,
                        Toast.LENGTH_SHORT
                    ).show()
                },
                Response.ErrorListener { error ->
                    // Manejar errores de la solicitud
                    val errorMessage = error.message
                    Toast.makeText(
                        context,
                        "Error: ${error.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }){
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
            //en caso que la petición falle
            Toast.makeText(
                context,
                "Error en la petición",
                Toast.LENGTH_LONG
            ).show()
        }
    }
        /*
        este método trae la lista de los productos
        este método se debe ejecutar en segundo plano
        para no afectar el cargue de la aplicación
        se agrega el modificador suspend
         */

   suspend fun consultarListaProductos(context: Context): MutableList<productos>{
       var url=urlBase+"listarjson"
        //se crea la lista de productos nula
        var listaProductos= mutableListOf<productos>()
        try{
            //try: intente hacer la petición

            //esta variable determina que la petición a terminado
            var peticionTerminada=false
            //se hace la petición
            var stringQuest=StringRequest(
                Request.Method.GET,
                url,
                Response.Listener<String> {response->
                        //petición correcta
                    //la variable response, tiene la respuesta del servidor
                    val Gson= Gson()
                    //Gson es la librería que permite las conversiones de JSON
                    listaProductos=Gson.fromJson( response,
                        object : TypeToken<MutableList<productos>>(){}.type
                    )
                    peticionTerminada=true
                }, Response.ErrorListener {Error->
                        //Error en la petición


                    Toast.makeText(
                        context,
                        "Error en la petición ${Error.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    peticionTerminada=true
                }
            )
            //se agrega la petición a la cola
            val queue = Volley.newRequestQueue(context)
            queue.add(stringQuest)
                //se detiene la ejecución del método mientras la petición no termina
               while (!peticionTerminada && listaProductos.size==0){
                    //se detiene mientras no se guarde un producto
                    kotlinx.coroutines.delay(500) // Pausa de 500 ms
                }

        }catch (Error: Exception){
            //catch capturar el error
        }finally {
            //independiente de que funcione o genere error
            //se dirige al finally
            return listaProductos
        }
    }
}