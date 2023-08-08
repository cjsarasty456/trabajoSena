package com.example.crudmovil

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudmovil.controller.productoController
import com.example.crudmovil.model.producto
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [listarProductoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class listarProductoFragment : Fragment() {

    private var listaProductos:MutableList<producto> = mutableListOf()
    private lateinit var recycler:RecyclerView

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
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_listar_producto, container, false)
        recycler=view.findViewById(R.id.LVProductos)

        realizarConsulta(context)
        var btnAnadir=view.findViewById<FloatingActionButton>(R.id.btnAnadir)
        btnAnadir.setOnClickListener{
            val transaction=requireFragmentManager().beginTransaction()
            transaction.replace(R.id.frame_layout_main,registrarProductoFragment()).commit()
            transaction.addToBackStack(null)
        }

        return view
    }
fun realizarConsulta(context: Context?) {
    var productoController=productoController()
    GlobalScope.launch(Dispatchers.Main) {
        try {
            listaProductos=productoController.consultarListaProductos(context)
            recycler.layoutManager=LinearLayoutManager(context)
            var adapter=recyclerProducto(context,listaProductos)
            adapter.onItemClick={
//                            Toast.makeText(context,"item ${it.nombre}", Toast.LENGTH_LONG).show()
                val bundle=Bundle()
                bundle.putInt("producto_id",it.id)
                val transaction=requireFragmentManager().beginTransaction()
                var fragmento=detalleProductoFragment()
                fragmento.arguments=bundle
                transaction.replace(R.id.frame_layout_main,fragmento).commit()
                transaction.addToBackStack(null)

            }
            recycler.adapter=adapter
        } catch (e: Exception) {
            Toast.makeText(context,"error",Toast.LENGTH_LONG).show()
        }
    }
}


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment listarProductoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            listarProductoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}