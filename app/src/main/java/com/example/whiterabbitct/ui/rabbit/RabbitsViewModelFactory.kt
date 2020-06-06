package com.example.whiterabbitct.ui.rabbit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whiterabbitct.repositories.RabbitRepository

@Suppress("UNCHECKED_CAST")
class RabbitsViewModelFactory(
    private val repository: RabbitRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RabbitsViewModel(repository) as T
    }

}