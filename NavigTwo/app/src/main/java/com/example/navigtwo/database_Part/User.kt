package com.example.navigtwo.database_Part

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val firstName: String,
    val firstPoints: String,
    val secondPoints: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}