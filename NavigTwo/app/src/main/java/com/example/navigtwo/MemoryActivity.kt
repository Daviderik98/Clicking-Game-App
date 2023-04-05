package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button

class MemoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)

        val memoriesTo = Intent(this, NextUpActivity::class.java)
        val toNextPage: Button = findViewById(R.id.btn_NextPage)

        toNextPage.setOnClickListener{
            startActivity(memoriesTo)
        }
    }
}