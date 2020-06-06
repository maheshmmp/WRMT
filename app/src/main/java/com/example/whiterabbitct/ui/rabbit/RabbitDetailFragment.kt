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
import com.example.whiterabbitct.databinding.RecyclerviewRabbitBinding
import kotlinx.android.synthetic.main.fragment_rabbit_detail.view.*


class RabbitDetailFragment : Fragment() {

    companion object {

        private const val RABBIT = "model"

        fun newInstance(dogModel: Rabbit): RabbitDetailFragment {
            val args = Bundle()
            args.putSerializable(RABBIT, dogModel)
            val fragment = RabbitDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
    //3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragmentDogDetailsBinding =
            RecyclerviewRabbitBinding.inflate(inflater, container, false)

        val model = arguments!!.getSerializable(RABBIT) as Rabbit
        fragmentDogDetailsBinding.rabbit = model
        Log.e("Sample>>", ""+ model.email + model.profile_image)
        return fragmentDogDetailsBinding.root
    }

}