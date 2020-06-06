package com.example.whiterabbitct.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.whiterabbitct.data.models.Address
import com.example.whiterabbitct.data.models.Company

@Entity
class Rabbit {

    @PrimaryKey
    var id: Int? = null

    var name: String? = null

    var username: String? = null

    var email: String? = null

    var profile_image: String ? = null

    val company : Company ? =null

    val phone: String ? = null

    val website: String ? = null

    val address: Address ? = null

    constructor()

    constructor(name: String?, username: String?, email: String?, profile_image: String?) {
        this.name = name
        this.username = username
        this.email = email
        this.profile_image = profile_image
    }
}