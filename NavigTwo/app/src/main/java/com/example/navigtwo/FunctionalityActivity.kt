package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.os.CountDownTimer
import androidx.core.view.isVisible

import android.content.Intent

private lateinit var timing: CountDownTimer

class FunctionalityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functionality)

        val finisher = Intent(this, MainActivity::class.java)

        val txtView: TextView = findViewById(R.id.textViewOne)
        val otherText: TextView = findViewById(R.id.textView2)
        val downcount: Button = findViewById(R.id.timeCountDown)
        var countdownValue: Int = 10




         timing = object : CountDownTimer(10_000, 1_000){
             //Open for calibration
            override fun onTick(remaining: Long) {
                countdownValue--
                downcount.isVisible = false
                txtView.text = countdownValue.toString()
            }
            override fun onFinish() {
                //txtView.text = "Done!"
                //downcount.isVisible = true
                //otherText.text = "When you click to start the timer, you will have to click on as many buttons as possible"
                startActivity(finisher)
            }
        }

        downcount.setOnClickListener{
            otherText.text = ""
            countdownValue = 11
          timing.start()

        }

    }
}