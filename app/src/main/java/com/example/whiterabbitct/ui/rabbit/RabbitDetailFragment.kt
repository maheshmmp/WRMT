package com.example.whiterabbitct.ui.rabbit

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.whiterabbitct.R
import com.example.whiterabbitct.data.models.Rabbit
import com.example.whiterabbitct.databinding.FragmentRabbitDetailBinding


class RabbitDetailFragment : Fragment() {

    companion object {

        private const val RABBIT = "RD"

        fun newInstance(dogModel: Rabbit): RabbitDetailFragment {
            val args = Bundle()
            args.putSerializable(RABBIT, dogModel)
            val fragment = RabbitDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentrabbitDetailsBinding =
            FragmentRabbitDetailBinding.inflate(inflater, container, false)

        val model = arguments?.getSerializable(RABBIT) as Rabbit
        fragmentrabbitDetailsBinding.rabbitdetail = model
        Log.e("Sample>>", "" + model.email + model.profile_image)
        return fragmentrabbitDetailsBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }



}