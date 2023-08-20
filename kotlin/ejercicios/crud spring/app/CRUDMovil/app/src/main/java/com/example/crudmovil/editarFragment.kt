package com.example.crudmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.crudmovil.controller.productoController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [editarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class editarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var producto_id:Int=0
    private lateinit var txtId: EditText
    private lateinit var txtNombre: EditText
    private lateinit var txtDescripcion: EditText
    private lateinit var txtPrecio: EditText
    private lateinit var txtCantidad: EditText

    private lateinit var btnGuardar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            producto_id=it.getInt("producto_id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_editar, container, false)
        txtId = view.findViewById<EditText>(R.id.txtId)
        txtNombre = view.findViewById<EditText>(R.id.txtNombre)
        txtDescripcion = view.findViewById<EditText>(R.id.txtDescripción)
        txtPrecio = view.findViewById<EditText>(R.id.txtPrecio)
        txtCantidad = view.findViewById<EditText>(R.id.txtCantidad)
        var productoController = productoController()

        btnGuardar=view.findViewById(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            guardarRegistro()
        }

        GlobalScope.launch(Dispatchers.Main) {
            try {
                var producto = productoController.consultarProductoporId(context, producto_id)
                txtId.setText(producto.id.toString())
                txtNombre.setText(producto.nombre.toString())
                txtDescripcion.setText(producto.descripcion.toString())
                txtPrecio.setText(producto.precio.toString())
                txtCantidad.setText(producto.cantidad.toString())

            } catch (e: Exception) {
                Toast.makeText(context, "error ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
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
            var producto:productoController=productoController()
            var retorno=producto.guardarProducto(
                context,
                0,
                txtNombre.text.toString(),
                txtDescripcion.text.toString(),
                txtPrecio.text.toString(),
                txtCantidad.text.toString(),
            )
        }else {
            Toast.makeText(context,"Error guardar, intente proximamente",Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment editarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            editarFragment().apply {
            }
    }
}