package com.example.test_kotlin

class program {
    fun login(user:String,pass:String):Boolean{
        var userCorrect="admin"
        var passCorrect="admin"

        return user==userCorrect && pass==passCorrect
    }

}