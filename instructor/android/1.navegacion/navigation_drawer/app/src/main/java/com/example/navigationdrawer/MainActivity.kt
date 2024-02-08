package com.example.navigationdrawer


import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView

//se agrega la librería y listener
// NavigationView.OnNavigationItemSelectedListener
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer:DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar =findViewById<Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer=findViewById<DrawerLayout>(R.id.drawer_layout)

        toggle= ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView:NavigationView=findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        //habilitar el frame inicial
        val manager=supportFragmentManager
        val transaction=manager.beginTransaction()
        transaction.add(R.id.frame_layout_main,firstFragment()).commit()
        transaction.addToBackStack(null)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.nav_item_one->{
                val manager=supportFragmentManager
                val transaction=manager.beginTransaction()
                transaction.replace(R.id.frame_layout_main,firstFragment()).commit()
                transaction.addToBackStack(null)
            }
            R.id.nav_item_two->{
                val manager=supportFragmentManager
                val transaction=manager.beginTransaction()
                transaction.replace(R.id.frame_layout_main,secondFragment()).commit()
                transaction.addToBackStack(null)
            }
            R.id.nav_item_three->Toast.makeText(
                this,
                "item 3",
                Toast.LENGTH_SHORT
            ).show()
            R.id.nav_item_four->Toast.makeText(
                this,
                "item 4",
                Toast.LENGTH_SHORT
            ).show()
            R.id.nav_item_five-> {
                var intent=Intent(this,account::class.java)
                startActivity(intent)
            }
            R.id.nav_item_six->{
                var intent=Intent(this,setting::class.java)
                startActivity(intent)
            }
        }


        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}