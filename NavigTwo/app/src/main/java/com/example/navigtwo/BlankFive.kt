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
 * Use the [BlankFive.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFive : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fifthView = inflater.inflate(R.layout.fragment_blank_five, container, false)

        val fromFiveBack: Button = fifthView.findViewById(R.id.button5)
        fromFiveBack.setOnClickListener{
            Navigation.findNavController(fifthView).navigate(R.id.action_blankFive_to_blankOne)
        }


        return fifthView
    }

}