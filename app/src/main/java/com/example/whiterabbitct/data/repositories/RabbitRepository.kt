package com.example.whiterabbitct.repositories

import com.example.whiterabbitct.data.network.RabbitApi
import net.simplifiedcoding.data.repositories.SafeApiRequest

class RabbitRepository(
    private val api: RabbitApi
) : SafeApiRequest() {

    suspend fun getRabbits() = apiRequest {api.getRabbits()}

}