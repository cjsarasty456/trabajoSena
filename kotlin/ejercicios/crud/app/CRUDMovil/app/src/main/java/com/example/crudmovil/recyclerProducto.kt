package com.example.crudmovil

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crudmovil.model.producto

class recyclerProducto
    (var context:Context, var listaProductos:MutableList<producto>):
    RecyclerView.Adapter<recyclerProducto.MyHolder>() {

        inner class MyHolder(Itemview: View):RecyclerView.ViewHolder(Itemview){
            lateinit var nombre:TextView
            lateinit var precio:TextView
            init{
                nombre=itemView.findViewById(R.id.lblNombre)
                precio=itemView.findViewById(R.id.lblPrecio)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return MyHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var producto=listaProductos[position]
        holder.nombre.text=producto.nombre
        holder.precio.text=producto.precio
    }
}