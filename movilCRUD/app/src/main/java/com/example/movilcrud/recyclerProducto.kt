package com.example.movilcrud

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.movilcrud.model.productos

class recyclerProducto
    (var context: Context?, var listaProductos:MutableList<productos>):
    RecyclerView.Adapter<recyclerProducto.MyHolder>() {


}
