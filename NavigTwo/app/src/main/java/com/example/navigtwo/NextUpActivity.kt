package com.example.navigtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NextUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_up)

        val nameInsert: Button = findViewById(R.id.buttonAdder)
        nameInsert.setOnClickListener{
            //Insert the followin code: -Navigate via Intent to next, - Snackbar with Undo option,

            //Placeholder
            val intendBack = Intent(this, MainActivity::class.java)
            startActivity(intendBack)
        }
    }
}