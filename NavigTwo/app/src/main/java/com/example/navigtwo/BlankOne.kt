package com.example.navigtwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.navigation.Navigation




class BlankOne : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val firstView = inflater.inflate(R.layout.fragment_blank_one, container, false)

        val batMan: Button = firstView.findViewById(R.id.buttonOne)
        batMan.isVisible = true // going to manipulate this soon with : if(otherText != ""){ false}

        batMan.setOnClickListener{
            Navigation.findNavController(firstView).navigate(R.id.action_blankOne_to_blankTwo)
        }

        return firstView
    }


}