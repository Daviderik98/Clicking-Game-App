package com.example.navigtwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels

import androidx.navigation.Navigation
import com.example.navigtwo.Counter.SharedViewModel


class BlankOne : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val sharedViewOne: SharedViewModel by activityViewModels()
        // Inflate the layout for this fragment
        val firstView = inflater.inflate(R.layout.fragment_blank_one, container, false)

        firstView.setOnClickListener{
            sharedViewOne.deCrease()
        }

        val batMan: Button = firstView.findViewById(R.id.buttonOne)
            batMan.isVisible = true


            batMan.text = sharedViewOne.phraseList[sharedViewOne.toIndex()]




        batMan.setOnClickListener{
            if(sharedViewOne.isClickable){
                //Replace with Indexing-Function
                sharedViewOne.inCrease()
                Navigation.findNavController(firstView).navigate(R.id.action_blankOne_to_blankTwo)
            }
            //Navigation.findNavController(firstView).navigate(R.id.action_blankOne_to_blankTwo)
        }

        return firstView
    }


}