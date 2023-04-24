package com.example.navigtwo.database_Part

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun addOneUser(user: User)

    @Query("SELECT * FROM User")
    fun fetchAllUsers():List<User>
}