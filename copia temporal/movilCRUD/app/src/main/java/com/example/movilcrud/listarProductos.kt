package com.example.movilcrud

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movilcrud.controller.productoController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class listarProductos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_productos)
        //se hace la petición de la listo de producto
        //se ejecuta en segundo plano
        var context=this
        GlobalScope.launch(Dispatchers.Main){
            var productoController=productoController()
            productoController.consultarListaProductos(context)
        }
    }
}