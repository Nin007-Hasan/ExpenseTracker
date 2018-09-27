package com.hihasan.expensetracker

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class StartupActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        checkConnection()




    }

    private fun checkConnection() {
        if (isOnline()==true){
            val i=Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }

        else{
            val i=Intent(applicationContext,NoInternet::class.java)
            startActivity(i)

        }

    }

    protected fun isOnline(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return if (netInfo != null && netInfo.isConnectedOrConnecting) {
            true
        } else {
            false
        }
    }

}