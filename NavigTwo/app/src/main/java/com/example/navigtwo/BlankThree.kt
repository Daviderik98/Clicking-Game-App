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
 * Use the [BlankThree.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankThree : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val thirdView = inflater.inflate(R.layout.fragment_blank_three, container, false)

        val fromThird: Button = thirdView.findViewById(R.id.button3)

        fromThird.setOnClickListener{
            Navigation.findNavController(thirdView).navigate(R.id.action_blankThree_to_blankFour)
        }


        return thirdView
    }

}