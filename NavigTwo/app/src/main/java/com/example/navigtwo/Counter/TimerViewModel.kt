package com.example.navigtwo.Counter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TimerViewModel: ViewModel() {
    private var timerState = MutableStateFlow(Onlyfortimer())
    val timerValue: StateFlow<Onlyfortimer> = timerState.asStateFlow()

    fun minusOne(){
        timerState.update{
            state -> state.copy(
            countingValue = state.countingValue - 1
            )
        }
    }
}