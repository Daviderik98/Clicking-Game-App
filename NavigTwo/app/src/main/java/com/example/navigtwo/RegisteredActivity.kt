package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.navigtwo.API_part.WordApi
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class RegisteredActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {    // Where I use my API
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registered)
        val onScreen: TextView = findViewById(R.id.openParagraph)


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
                    onScreen.text = answer.toString()
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}