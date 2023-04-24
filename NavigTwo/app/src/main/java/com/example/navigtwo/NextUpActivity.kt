package com.example.navigtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.EditTextPreference
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.navigtwo.Counter.SecondSharedModel
import com.example.navigtwo.Counter.SharedViewModel


class NextUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_up)

        val scoreFromFirst: String = intent.getStringExtra("Score_from_One").toString()
        val scoreFromSecond: String = intent.getStringExtra("Score_from_Two").toString()


        val showScore: TextView = findViewById(R.id.textView4)
        //val firstPoint: String = sharedVMthree.finalScoreOne
        //val scoreText: String = firstPoint
        showScore.text = "And your scores are : $scoreFromFirst , $scoreFromSecond"



        val entered: EditText= findViewById(R.id.enterNames)
        var enteredTxt: String = entered.text.toString()



        val nameInsert: Button = findViewById(R.id.buttonAdder)
        nameInsert.setOnClickListener{
            enteredTxt = entered.text.toString()
            println("TRANSMITTING OVER : $enteredTxt")

            //Insert the followin code: -Navigate via Intent to next, - Snackbar with Undo option,
            val towardsLast = Intent(this, RegisteredActivity::class.java).apply{
                putExtra("key_playerName", enteredTxt)
                putExtra("GameScore_One", scoreFromFirst)
                putExtra("GameScore_Two", scoreFromSecond)
            }
            startActivity(towardsLast)
        }

        val standardSign: TextView = findViewById(R.id.underTEXT)
        standardSign.setOnClickListener{
            enteredTxt = "Player"
            println("$enteredTxt : SIGNING OFF")
            val toTheLastAct = Intent(this, RegisteredActivity::class.java).apply{
                putExtra("key_playerName", "Player")
                putExtra("GameScore_One", scoreFromFirst)
                putExtra("GameScore_Two", scoreFromSecond)
            }
startActivity(toTheLastAct)
        }
        //Placeholder
        //val intendBack = Intent(this, MainActivity::class.java)
        //startActivity(intendBack)
    }
}