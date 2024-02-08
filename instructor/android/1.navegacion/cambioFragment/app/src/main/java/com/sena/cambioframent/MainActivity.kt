package com.sena.cambioframent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val fragmentManager = supportFragmentManager
         val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = primerFragment()
        fragmentTransaction.add(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
        var btnPrimerFragment=findViewById<Button>(R.id.btnPrimerFrament)
        var btnSegundoFrament=findViewById<Button>(R.id.btnSegundoFrament)
        var btnTercerFrament=findViewById<Button>(R.id.btnTercerFrament)


        btnPrimerFragment.setOnClickListener {
            cambioFragment(1)
        }
        btnSegundoFrament.setOnClickListener {
            cambioFragment(2)
        }
        btnTercerFrament.setOnClickListener {
            cambioFragment(3)
        }
    }

    fun cambioFragment(position:Int){
        var fragment:Fragment=primerFragment()
        when(position){
            1->fragment=primerFragment()
            2->fragment=segundoFragment()
            3->fragment=tercerFragment()

        }
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}