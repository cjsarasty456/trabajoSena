package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.model.producto


class MainActivity : AppCompatActivity() {
    var producto=producto(
        "1",
        "Papa",
        "lorem ipsum solar",
        "1000",
        "10"
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}