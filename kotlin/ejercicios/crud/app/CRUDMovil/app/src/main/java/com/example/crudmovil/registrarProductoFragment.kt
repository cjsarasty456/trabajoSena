package com.example.crudmovil

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

import java.lang.Exception


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [registrarProductoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class registrarProductoFragment : Fragment() {

lateinit var txtNombre:EditText
lateinit var txtDescripcion:EditText
lateinit var txtPrecio:EditText
lateinit var txtCantidad:EditText
lateinit var txtImagen:EditText
lateinit var btnVolver:Button
lateinit var btnLimpiar:Button
lateinit var btnGuardar:Button
lateinit var btnImagen:Button

    lateinit var txtLog:EditText

var Nombre:String=""
var Descripcion:String=""
var Precio: String=""
var Cantidad:String=""


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view=inflater.inflate(R.layout.fragment_registrar_producto, container, false)
        txtNombre= view.findViewById(R.id.txtNombre)
        txtDescripcion= view.findViewById(R.id.txtDescripcion)
        txtPrecio= view.findViewById(R.id.txtPrecio)
        txtCantidad= view.findViewById(R.id.txtCantidad)
        btnGuardar= view.findViewById(R.id.btnGuardar)
        btnLimpiar= view.findViewById(R.id.btnLimpiar)
        btnVolver= view.findViewById(R.id.btnVolver)
        btnImagen= view.findViewById(R.id.btnImagen)
        txtLog=view.findViewById(R.id.txtLog)

        btnGuardar.setOnClickListener{
            guardarRegistro()
        }
        btnLimpiar.setOnClickListener {
            limpiarRegistro()
        }
        btnVolver.setOnClickListener {
            volver()
        }

        // Inflate the layout for this fragment
        return view
    }

    fun guardarRegistro() {

        var validacion = true
        if (txtNombre.text.toString() == "") {
            validacion = false
            txtNombre.error = "El campo nombre es requerido"
        }
        if (txtDescripcion.text.toString() == "") {
            validacion = false
            txtDescripcion.error = "El campo descripción es requerido"
        }
        if (txtCantidad.text.toString() == "") {
            validacion = false
            txtCantidad.error = "El campo cantidad es requerido"
        }
        if (txtPrecio.text.toString() == "") {
            validacion = false
            txtPrecio.error = "El campo precio es requerido"
        }
        if (validacion) {
            Nombre = txtNombre.text.toString()
            Descripcion = txtDescripcion.text.toString()
            Precio= txtPrecio.text.toString()
            Cantidad = txtCantidad.text.toString()

            val url =
                "https://laminose-salutes.000webhostapp.com/controller/productosController.php"
            val queue = Volley.newRequestQueue(context)
            val stringRequest = object : StringRequest(
                Request.Method.POST, url,
                Response.Listener<String> { response ->
                    txtLog.setText(" ${txtLog.text.toString()}, ${response} ")
//
//                    }
                }, Response.ErrorListener { error ->
                    txtLog.setText(" ${txtLog.text.toString()}, ${error} ")

                }
            ) {
                override fun getParams(): MutableMap<String, String> {

                    val parametros = HashMap<String, String>()
                    parametros.put("function", "guardarProducto")
                    parametros.put("id", "0")
                    parametros.put("nombre", Nombre)
                    parametros.put("descripcion", Descripcion)
                    parametros.put("precio", Precio)
                    parametros.put("cantidad", Cantidad)
                    parametros.put("imagen", " ")
                    return parametros
                }
            }
            queue.add(stringRequest)

        }
    }
    fun limpiarRegistro(){

    }
    fun volver(){

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment registrarProductoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            registrarProductoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}