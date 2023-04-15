package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.navigtwo.Counter.SharedViewModel
import kotlinx.coroutines.launch

class MemoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedVMtwo: SharedViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)

        println(sharedVMtwo.finalScoreOne)



        val memoriesTo = Intent(this, NextUpActivity::class.java)
        val toNextPage: Button = findViewById(R.id.btn_NextPage)

        val forMorePoints: TextView = findViewById(R.id.sameScore)
        val entryOne: EditText = findViewById(R.id.editForInsertWord)
        val correctButton: Button = findViewById(R.id.btn_ForEntry)

        //ViewModel LifeCycle
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedVMtwo.currentState.collect() {
                    //Update UI elements
                    forMorePoints.text = sharedVMtwo.currentState.value.currentScore.toString()

                }
            }
        }

        correctButton.setOnClickListener{
            sharedVMtwo.toCorrect(entryOne.toString())
        }

        toNextPage.setOnClickListener{
            startActivity(memoriesTo)
        }
    }
}