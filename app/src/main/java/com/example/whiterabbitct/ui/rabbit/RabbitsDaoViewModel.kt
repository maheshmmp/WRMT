package com.example.whiterabbitct.ui.rabbit

import androidx.lifecycle.ViewModel
import com.example.whiterabbitct.application.RabbitApplication
import com.example.whiterabbitct.data.database.Rabbit

class RabbitsDaoViewModel : ViewModel() {

    private var listRabbit: List<Rabbit>? = null

    fun getRabbits(): List<Rabbit> {
        if (listRabbit == null) {
            listRabbit = RabbitApplication.database?.getRabbits()?.getAllRabbits()
        }
        return listRabbit!!
    }

}