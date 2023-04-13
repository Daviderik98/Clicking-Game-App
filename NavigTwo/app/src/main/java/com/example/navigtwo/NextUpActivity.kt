package com.example.navigtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.EditTextPreference
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



        val entered: EditText= findViewById(R.id.enterNames)
        var enteredTxt: String = entered.text.toString()



        val nameInsert: Button = findViewById(R.id.buttonAdder)
        nameInsert.setOnClickListener{
            enteredTxt = entered.text.toString()
            println("TRANSMITTING OVER : $enteredTxt")

            //Insert the followin code: -Navigate via Intent to next, - Snackbar with Undo option,
            val towardsLast = Intent(this, RegisteredActivity::class.java).apply{
                putExtra("key_playerName", enteredTxt)
            }
            startActivity(towardsLast)
        }

        val standardSign: TextView = findViewById(R.id.underTEXT)
        standardSign.setOnClickListener{
            enteredTxt = "Player"
            println("$enteredTxt : SIGNING OFF")
            val toTheLastAct = Intent(this, RegisteredActivity::class.java).apply{
                putExtra("key_playerName", "Player")
            }
startActivity(toTheLastAct)
        }
        //Placeholder
        //val intendBack = Intent(this, MainActivity::class.java)
        //startActivity(intendBack)
    }
}