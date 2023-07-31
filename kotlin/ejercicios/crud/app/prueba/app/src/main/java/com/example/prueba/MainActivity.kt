package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.prueba.model.producto
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject



class MainActivity : AppCompatActivity() {
   lateinit var txtTexto:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtTexto=findViewById(R.id.texto)
//        val queue = Volley.newRequestQueue(this)
//        val url = "https://laminose-salutes.000webhostapp.com/controller/productosController.php?function=consultarListaProductos"
//
//// Request a string response from the provided URL.
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            Response.Listener<String> { response ->
//                // Display the first 500 characters of the response string.
//                Toast.makeText(this,"success ${response}",Toast.LENGTH_LONG).show()
//            },
//            Response.ErrorListener {
//                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
//            })
//
//// Add the request to the RequestQueue.
//        queue.add(stringRequest)
        val url = "https://laminose-salutes.000webhostapp.com/controller/productosController.php?function=consultarListaProductos"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
            try{
//                txtTexto.text=response
                val json=JSONArray(response)
                var prueba="hola"
//                txtTexto.text=json.toString()
                for(i in 0 until json.length()){
                    val registro=json.getJSONObject(i)
                    Toast.makeText(this,registro.getString("nombre"),Toast.LENGTH_LONG).show()
                }
            }catch (e:JSONException){
                txtTexto.text="Error"
            }
            },Response.ErrorListener { error->
                txtTexto.text="Error Petición ${error}"
            }
            )
        queue.add(stringRequest)


    }
}