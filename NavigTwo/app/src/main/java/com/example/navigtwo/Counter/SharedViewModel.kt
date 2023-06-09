package com.example.navigtwo.Counter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

import kotlin.collections.ArrayList



class SharedViewModel: ViewModel() {

    var isClickable: Boolean = false // Manipulate later, when it works

    //Initialize the Timer and make it so other components turn invisible
    private val visible = MutableStateFlow(TimerIsOn())
    val visibleValue = visible.asStateFlow()

    fun switchVisible(){
        visible.update{
            state -> state.copy(
            timerOn = true
            )
        }
    }




    val phraseList: ArrayList<String> = ArrayList(arrayListOf("MASSIVE", "SHADOW", "FOREST", "MOUNTAINS", "EVERLASTING", "GUARDIAN", "DIVERSITY", "WISHES", "ARCHERS", "WEAPONS", "FREEDOM", "PEACE", "UTOPIA", "WARRIOR", "SILENT", "HARMONY", "SIRENS", "SHIPWRECK", "CAVE-IN", "BEACONS", "ROADTRIP", "MANIA", "SOUNDWAVES", "BLUE", "HEARTS", "REGRET", "FOLLOW", "METAL", "LIGHTS", "SMART", "DYSTOPIA", "STRENGTH", "SOFT", "PROTECT", "HURT"))
    val maxIndex: Int = phraseList.size - 1
    // To Replace var indexing
    fun toIndex(): Int {
        var myRand: Int = (0..maxIndex).random()
        return myRand
    }

    //Setup mutableStateFlow
    private var _uiState = MutableStateFlow(CounterStates())
    val currentState: StateFlow<CounterStates> = _uiState.asStateFlow()



    fun inCrease(){
        _uiState.update{
            state -> state.copy(
            currentScore = state.currentScore + 6
            )
        }
        //Just wanted to check if this state would work, and it sort of did
        println(_uiState.toString())
        println("Challenge ACCEPTED!")
    }

    fun deCrease(){
_uiState.update{
    state -> state.copy(
    currentScore = state.currentScore - 5
    )
}
        println("THIS MESSAGE IS ABOUT your revoked climbing liscence")
    }

}