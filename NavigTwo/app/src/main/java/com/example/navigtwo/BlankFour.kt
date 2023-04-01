package com.example.navigtwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.navigtwo.Counter.SharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [BlankFour.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFour : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sharedViewFour: SharedViewModel by viewModels()
        // Inflate the layout for this fragment
        val fourthView = inflater.inflate(R.layout.fragment_blank_four, container, false)
        fourthView.setOnClickListener{
            sharedViewFour.deCrease()
        }

        val fromFour: Button = fourthView.findViewById(R.id.button4)

        fromFour.setOnClickListener{
            sharedViewFour.inCrease()
            Navigation.findNavController(fourthView).navigate(R.id.action_blankFour_to_blankFive)
        }

        return fourthView
    }


}