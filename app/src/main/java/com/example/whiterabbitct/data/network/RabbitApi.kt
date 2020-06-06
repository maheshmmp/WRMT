package com.example.whiterabbitct.data.network

import com.example.whiterabbitct.data.models.Rabbit
import com.example.whiterabbitct.util.SSL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RabbitApi {

    @GET("5d565297300000680030a986")
    suspend fun getRabbits() : Response<List<Rabbit>>


    companion object{
        operator fun invoke() : RabbitApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.mocky.io/v2/")
                .client(SSL.getUnsafeOkHttpClient().build())
                .build()
                .create(RabbitApi::class.java)
        }
    }
}