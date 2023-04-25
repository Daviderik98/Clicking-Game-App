package com.example.navigtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.navigtwo.API_part.WordApi
import com.example.navigtwo.Counter.SecondSharedModel
import com.example.navigtwo.Counter.SharedViewModel
import com.example.navigtwo.database_Part.User
import com.example.navigtwo.database_Part.UserDataBase
import com.example.navigtwo.database_Part.UserRepository
import kotlinx.coroutines.Dispatchers
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class RegisteredActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {    // Where I use my API

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registered)

        val db = UserDataBase.getDatabase(applicationContext)
        val usersRepo = UserRepository(db, lifecycleScope)

        val onScreen: TextView = findViewById(R.id.openParagraph)

        //For Restart
        val restartGame: Button = findViewById(R.id.Return_to_Start)
        val restartCommand = Intent(this, MainActivity::class.java)
        restartGame.setOnClickListener{
            startActivity(restartCommand)
        }

        //For Viewing the Database-Content
        val toTheDB: Button = findViewById(R.id.toDataBase)
        val viewDB = Intent(this, DBViewActivity::class.java)
        toTheDB.setOnClickListener{
            startActivity(viewDB)
        }

        //Variables for printing out on TextViews
        val broughtText: String = intent.getStringExtra("key_playerName").toString()
        val showFirstScore: String = intent.getStringExtra("GameScore_One").toString()
        val showSecondScore: String = intent.getStringExtra("GameScore_Two").toString()
        println("First Game Score = ")
        println("Second Game Score = ")
        //Printing out the Scores
        val firstPoints: TextView = findViewById(R.id.viewScoreOne)
        firstPoints.text = "Clicking Game : $showFirstScore"
        val secondPoints: TextView = findViewById(R.id.viewScoreTwo)
        secondPoints.text = "Memory Game : $showSecondScore"

        var fullName: String = "Insert_Here"


        //Building my API link below
        val retrofit = Retrofit.Builder()
            .baseUrl("https://random-word-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val receivedWord = retrofit.create<WordApi>().getTheWord()
        receivedWord.enqueue(object: Callback<List<String>>{
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if(response.isSuccessful){
                    val answer = response.body()
                    println(answer)
                    val finalName: String = broughtText
                    println(finalName)
                    fullName = "[$finalName]_[$answer]"
                    onScreen.text = fullName
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                println("UNABLE TO ACQUIRE DATA")
            }



        })

        //First Interaction with Room DB
        val toRegister: Button = findViewById(R.id.btn_Registration)
toRegister.setOnClickListener{
    usersRepo.performDatabaseOperation(Dispatchers.IO){
        usersRepo.addOneUser(User(fullName, showFirstScore, showSecondScore))
        println("$fullName , $showFirstScore , $showSecondScore")
    }
}

    }
}