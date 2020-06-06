package com.example.whiterabbitct.ui.rabbit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import com.example.whiterabbitct.data.models.Rabbit
import com.example.whiterabbitct.repositories.RabbitRepository

class RabbitsViewModel(
    private val repository: RabbitRepository
) : ViewModel() {

    private lateinit var job: Job

    private val rabbits = MutableLiveData<List<Rabbit>>()
    val movies: LiveData<List<Rabbit>>
        get() = rabbits

    fun getRabbits() {
        job = Coroutines.ioThenMain(
            { repository.getRabbits() },
            { rabbits.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
