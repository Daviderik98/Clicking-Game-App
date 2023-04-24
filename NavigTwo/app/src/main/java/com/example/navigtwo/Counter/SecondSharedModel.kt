package com.example.navigtwo.Counter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SecondSharedModel: ViewModel() {



    private val _memoryState = MutableStateFlow(SecondCounterstate())
    val currentMemory = _memoryState.asStateFlow()

    fun secondIncrease(){//Need to modify this
        _memoryState.update{
                state -> state.copy(
            memoryScore = state.memoryScore + 9
        )
        }
        println("MEMORY SCORE UPDATED + 9")
    }
}