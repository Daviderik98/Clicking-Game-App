package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fromOneTwo = Intent(this, AboutActivity::class.java)

        val onlyButtonOne: Button = findViewById(R.id.buttonFirst)
        onlyButtonOne.setOnClickListener{
            startActivity(fromOneTwo)
        }
    }
}