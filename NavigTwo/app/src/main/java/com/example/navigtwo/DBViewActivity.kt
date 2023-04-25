package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.navigtwo.database_Part.User
import com.example.navigtwo.database_Part.UserDataBase
import com.example.navigtwo.database_Part.UserRepository
import kotlinx.coroutines.Dispatchers

class DBViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbview)

        val data_base = UserDataBase.getDatabase(applicationContext)
        val userRepository = UserRepository(data_base, lifecycleScope)

        val showAllUsers: TextView = findViewById(R.id.printOutAllInDB)

        userRepository.performDatabaseOperation(Dispatchers.IO){
            val showAllDataSoFar: List<User> = userRepository.fetchUserList()

            userRepository.performDatabaseOperation(Dispatchers.Main){
                showAllUsers.text = showAllDataSoFar.toString()
            }
        }

    }
}