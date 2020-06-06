package com.example.whiterabbitct.ui.rabbit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.whiterabbitct.R
import com.example.whiterabbitct.data.models.Rabbit
import kotlinx.android.synthetic.main.fragment_rabbit_detail.view.*


class RabbitDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bundle = arguments
        val rabbit: Rabbit? = bundle!!.getSerializable("RB") as Rabbit?
        Log.e("Name>>", " "+rabbit?.name)

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