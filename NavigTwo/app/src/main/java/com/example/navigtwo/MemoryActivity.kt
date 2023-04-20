package com.example.navigtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.navigtwo.Counter.SharedViewModel
import kotlinx.coroutines.launch

class MemoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedVMtwo = ViewModelProvider(this).get(SharedViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)

        println(sharedVMtwo.finalScoreOne)



        val memoriesTo = Intent(this, NextUpActivity::class.java)
        val toNextPage: Button = findViewById(R.id.btn_NextPage)

        val forMorePoints: TextView = findViewById(R.id.sameScore)
        val entryOne: EditText = findViewById(R.id.editForInsertWord)
        val correctButton: Button = findViewById(R.id.btn_ForEntry)

        val answers: ArrayList<String> = arrayListOf((""))

        //ViewModel LifeCycle
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedVMtwo.currentState.collect() {
                    //Update UI elements
                    forMorePoints.text = sharedVMtwo.otherState.value.memoryScore.toString()

                }
            }
        }

        fun toCorrect(inPut: String): Int{


            var whatFound: Int = 0
            val ansIndex: Int = answers.size - 1
            var whatAnswer: Int = 2

            for(j in 0..ansIndex) {
                if (answers[j] == inPut) {
                    println("You DO NOT GET POINTS FOR THE SAME WORD TWICE")
                    whatAnswer++
                    break
                }
            }
                if(whatAnswer != 2){
                    println("ENTERING THE SAME WORD TWICE IS NOT ALLOWED FOR POINTS")
                }
                else{
                    for(i in 0..sharedVMtwo.maxIndex) {
                        if (sharedVMtwo.phraseList[i] == inPut) {

                            whatFound = 5
                        }
                    }
                    if(whatFound == 5){
                        println("ONE WORD FOUND")
                    }
                    else{
                        println("WE FOUND NO SUCH WORD")
                    }
                }


             return whatFound
        }

        correctButton.setOnClickListener{
            val userInText: String = entryOne.text.toString()
            //Only printed out to test it : println(userInText)
            val rightOrWrong: Int = toCorrect(userInText)
            if(rightOrWrong == 5){
                sharedVMtwo.secondIncrease()
            }
            answers.add(userInText)
        }

        toNextPage.setOnClickListener{
            sharedVMtwo.finalScoreTwo = forMorePoints.text.toString()
            println("Final Score of Memory Game = ${sharedVMtwo.finalScoreTwo}")
            startActivity(memoriesTo)
        }
    }
}