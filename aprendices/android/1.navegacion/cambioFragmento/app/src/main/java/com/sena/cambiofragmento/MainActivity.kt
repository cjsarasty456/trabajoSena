package com.sena.cambiofragmento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //Se crea el método para el cambio de los fragmentos
    //recibe un valor que indica el número de fragmento
    fun cambioFragmento(position:Int){
        //when
        var fragment:Fragment=firstFragment()
        when(position){

            1->fragment= firstFragment()
            2->fragment=secondFragment()
            3->fragment=thirdFragment()

        }
        val fragmentManager=
            supportFragmentManager
        val fragmentTransaction=
            fragmentManager.beginTransaction()
        fragmentTransaction.
        replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()


    }
}