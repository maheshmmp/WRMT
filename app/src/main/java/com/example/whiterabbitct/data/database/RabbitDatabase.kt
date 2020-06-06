package com.example.whiterabbitct.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Rabbit::class), version = 1)
abstract class RabbitDatabase : RoomDatabase() {

    abstract fun getRabbits(): RabbitDao

}