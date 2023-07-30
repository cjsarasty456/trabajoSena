package com.example.crudmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //habilitar el frame inicial
        val manager=supportFragmentManager
        val transaction=manager.beginTransaction()
        transaction.add(R.id.frame_layout_main,registrarProductoFragment()).commit()
        transaction.addToBackStack(null)
    }
}