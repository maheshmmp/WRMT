package com.example.whiterabbitct.data.models

import java.io.Serializable

data class Rabbit (
    val id: Int,
    val name: String,
    val image: String,
    val profile_image: String ?= null,
    val company: Company,
    val email: String,
    val phone: String,
    val website: String,
    val address: Address
): Serializable