package com.example.whiterabbitct.ui.rabbit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whiterabbitct.R
import com.example.whiterabbitct.data.models.Rabbit


class RabbitDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rabbit_detail, container, false)
    }

    companion object {

        fun newInstance(rabbit: Rabbit) =
            RabbitDetailFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}