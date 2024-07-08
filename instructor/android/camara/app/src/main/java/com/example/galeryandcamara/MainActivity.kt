package com.example.galeryandcamara

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
//se agrega picker para seleccionar foto de galeria
    val pickMedia=registerForActivityResult(PickVisualMedia()){
        uri->
        //Imagen seleccionada
        if(uri!=null){
            IVPerfil.setImageURI(uri)
        }else{
            //No se seleccionó una imagen
        }
}
lateinit var btnImage:Button
lateinit var btnCamara:Button
lateinit var IVPerfil:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnImage=findViewById(R.id.btnImagen)
        btnCamara=findViewById(R.id.btnCamara)
        btnCamara.setOnClickListener {
            TakePicture()
        }
        IVPerfil=findViewById(R.id.IVPerfil)
        btnImage.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageAndVideo))

        }
    }
}