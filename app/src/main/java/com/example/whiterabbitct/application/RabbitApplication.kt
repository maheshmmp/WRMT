package com.example.whiterabbitct.application

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.whiterabbitct.data.database.RabbitDatabase

class RabbitApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        database = Room.databaseBuilder(this, RabbitDatabase::class.java, "rabbit-db").build()
    }


    companion object {
        var appContext: Context? = null
        var database: RabbitDatabase? = null
    }
}