package com.example.test_kotlin

import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class testing{

    @Test
    fun testLogin(){
        val program=program()
        var resultado:Boolean
        resultado=program.login("admin","admin")
        assertTrue("Error en el login",resultado)
        resultado=program.login("admin","admin2")
        assertTrue("Error en el login",resultado)
    }


}