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
import com.example.navigtwo.Counter.FourthViewModel
import com.example.navigtwo.Counter.SecondSharedModel
import com.example.navigtwo.Counter.SharedViewModel
import kotlinx.coroutines.launch

class MemoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedVMtwo = ViewModelProvider(this).get(SharedViewModel::class.java)
        val secondSharedVM = ViewModelProvider(this).get(SecondSharedModel::class.java)
        val fourthVM = ViewModelProvider(this).get(FourthViewModel::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)

        var finalScoreTwo: String = "Noneofmybusy"

        val fromFirstGM: String = intent.getStringExtra("first_Score").toString()
        val showPrevious: TextView = findViewById(R.id.previousPoints)
        showPrevious.text = fromFirstGM

        val memoriesTo = Intent(this, NextUpActivity::class.java)
        val toNextPage: Button = findViewById(R.id.btn_NextPage)

        val forMorePoints: TextView = findViewById(R.id.sameScore)
        val entryOne: EditText = findViewById(R.id.editForInsertWord)
        val correctButton: Button = findViewById(R.id.btn_ForEntry)



        //ViewModel LifeCycle
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                secondSharedVM.currentMemory.collect() {
                    //Update UI elements
                    forMorePoints.text = secondSharedVM.currentMemory.value.memoryScore.toString()

                }
            }
        }

        fun toCorrect(inPut: String): Int{


            var whatFound: Int = 0
            val ansIndex: Int = fourthVM.answers.size - 1
            var whatAnswer: Int = 2

            for(j in 0..ansIndex) {
                if (fourthVM.answers[j] == inPut) {
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
                secondSharedVM.secondIncrease()
            }
            fourthVM.answers.add(userInText)
        }

        toNextPage.setOnClickListener{
            finalScoreTwo = forMorePoints.text.toString()
            println("Final Score of Memory Game = $finalScoreTwo")
            memoriesTo.putExtra("Score_from_Two", finalScoreTwo)
            memoriesTo.putExtra("Score_from_One",fromFirstGM)
            startActivity(memoriesTo)
        }
    }
}