package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.os.CountDownTimer
import androidx.core.view.isVisible

import android.content.Intent
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.navigtwo.Counter.SharedViewModel
import kotlinx.coroutines.launch

private lateinit var timing: CountDownTimer

class FunctionalityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functionality)

        val showPoints: TextView = findViewById(R.id.showPoints)

        val sharedVM: SharedViewModel by viewModels()

        //ViewModel LifeCycle
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedVM.currentState.collect() {
                    //Update UI elements
                    showPoints.text = sharedVM.currentState.value.currentScore.toString()

                }
            }
        }


                                                  //Change Activity later, David
        val finisher = Intent(this, MemoryActivity::class.java)

        val txtView: TextView = findViewById(R.id.textViewOne)
        val otherText: TextView = findViewById(R.id.textView2)
        val downcount: Button = findViewById(R.id.timeCountDown)
        var countdownValue: Int = 10

        val scoreView: TextView = findViewById(R.id.viewForScores)



        scoreView.isVisible = false
        showPoints.isVisible = false







         timing = object : CountDownTimer(10_000, 1_000){
             //Open for calibration
            override fun onTick(remaining: Long) {
                countdownValue--
                downcount.isVisible = false
                 scoreView.isVisible = true
                 showPoints.isVisible = true
                 sharedVM.isClickable = true
                txtView.text = countdownValue.toString()
            }
            override fun onFinish() {
                println(scoreView.text.toString())
                println(showPoints.text.toString())

                //txtView.text = "Done!"
                //downcount.isVisible = true
                //otherText.text = "When you click to start the timer, you will have to click on as many buttons as possible"
                sharedVM.finalScoreOne = showPoints.text.toString()

                println("Presenting : ${sharedVM.finalScoreOne}")
                startActivity(finisher)
            }
        }



        downcount.setOnClickListener{
            sharedVM.isClickable = true//redundant, so I will fix this later
            otherText.text = ""
            countdownValue = 11
          timing.start()

        }

    }
}
