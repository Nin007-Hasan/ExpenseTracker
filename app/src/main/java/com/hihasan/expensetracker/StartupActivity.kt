package com.hihasan.expensetracker

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.hihasan.InternetConnectiivity;

class StartupActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        checkConnection()

    }

    private fun checkConnection() {
        var online= InternetConnectiivity().isOnline()
        if (online==true){
            val i=Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }

        else{
            val i=Intent(applicationContext,NoInternet::class.java)
            startActivity(i)

        }

    }


}