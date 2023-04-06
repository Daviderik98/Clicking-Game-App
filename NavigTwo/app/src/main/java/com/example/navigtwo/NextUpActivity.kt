package com.example.navigtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import com.example.navigtwo.Counter.SharedViewModel


class NextUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_up)

        val sharedVMthree: SharedViewModel by viewModels()

        val showScore: TextView = findViewById(R.id.textView4)
        val scoreText: String = sharedVMthree.currentState.value.currentScore.toString()
        showScore.text = "And your score : $scoreText"

        val nameInsert: Button = findViewById(R.id.buttonAdder)
        nameInsert.setOnClickListener{
            //Insert the followin code: -Navigate via Intent to next, - Snackbar with Undo option,

            //Placeholder
            val intendBack = Intent(this, MainActivity::class.java)
            startActivity(intendBack)
        }
    }
}