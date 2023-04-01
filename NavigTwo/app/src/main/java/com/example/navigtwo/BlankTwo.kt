package com.example.navigtwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation



/**
 * A simple [Fragment] subclass.
 * Use the [BlankTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankTwo : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val secondView = inflater.inflate(R.layout.fragment_blank_two, container, false)

        val fromTwo: Button = secondView.findViewById(R.id.button2)

        fromTwo.setOnClickListener{
            Navigation.findNavController(secondView).navigate(R.id.action_blankTwo_to_blankThree)
        }

        return secondView
    }


}