package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.content.Intent

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val fromTwoThree = Intent(this, FunctionalityActivity::class.java)
        val onlyButtonTwo: Button = findViewById(R.id.buttonSecond)

        onlyButtonTwo.setOnClickListener{
            startActivity(fromTwoThree)
        }
    }
}