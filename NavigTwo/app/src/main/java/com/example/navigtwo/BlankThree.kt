package com.example.navigtwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.navigtwo.Counter.SharedViewModel


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
        val sharedViewThree: SharedViewModel by activityViewModels()

        // Inflate the layout for this fragment
        val thirdView = inflater.inflate(R.layout.fragment_blank_three, container, false)
        thirdView.setOnClickListener{
            sharedViewThree.deCrease()
        }

        val fromThird: Button = thirdView.findViewById(R.id.button3)

        fromThird.setOnClickListener{
            sharedViewThree.inCrease()
            Navigation.findNavController(thirdView).navigate(R.id.action_blankThree_to_blankFour)
        }


        return thirdView
    }

}