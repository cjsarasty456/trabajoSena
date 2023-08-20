package com.example.crudmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudmovil.controller.productoController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match

/**
 * A simple [Fragment] subclass.
 * Use the [detalleProductoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class detalleProductoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var producto_id:Int=0
    private lateinit var lblId:TextView
    private lateinit var lblNombre:TextView
    private lateinit var lblDescripcion:TextView
    private lateinit var lblPrecio:TextView
    private lateinit var lblCantidad:TextView

    private lateinit var btnEditar:Button

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
        var view=inflater.inflate(R.layout.fragment_detalle_producto, container, false)
        lblId=view.findViewById<TextView>(R.id.lblId)
        lblNombre=view.findViewById<TextView>(R.id.lblNombre)
        lblDescripcion=view.findViewById<TextView>(R.id.lblDescripción)
        lblPrecio=view.findViewById<TextView>(R.id.lblPrecio)
        lblCantidad=view.findViewById<TextView>(R.id.lblCantidad)

        btnEditar=view.findViewById(R.id.btnEditar)

        var productoController=productoController()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                var producto=productoController.consultarProductoporId(context,producto_id)
                lblId.text=producto.id.toString()
                lblNombre.text=producto.nombre.toString()
                lblDescripcion.text=producto.descripcion.toString()
                lblPrecio.text=producto.precio.toString()
                lblCantidad.text=producto.cantidad.toString()

            } catch (e: Exception) {
                Toast.makeText(context,"error ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        btnEditar.setOnClickListener {
            val bundle=Bundle()
            bundle.putInt("producto_id",producto_id)
            val transaction=requireFragmentManager().beginTransaction()
            var fragmento=editarFragment()
            fragmento.arguments=bundle
            transaction.replace(R.id.frame_layout_main,fragmento).commit()
            transaction.addToBackStack(null)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment detalleProductoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            detalleProductoFragment().apply {
            }
    }
}