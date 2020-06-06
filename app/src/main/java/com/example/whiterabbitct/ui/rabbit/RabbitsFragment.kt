package com.example.whiterabbitct.ui.rabbit

import android.os.Bundle
import android.view.*
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whiterabbitct.R
import com.example.whiterabbitct.application.RabbitApplication
import com.example.whiterabbitct.data.models.Rabbit
import com.example.whiterabbitct.data.network.RabbitApi
import com.example.whiterabbitct.repositories.RabbitRepository
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.rabbits_fragment.*
import kotlinx.android.synthetic.main.toolbar.*


class RabbitsFragment : Fragment(), RecyclerViewClickListener{

    private lateinit var factory: RabbitsViewModelFactory
    private lateinit var viewModel: RabbitsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rabbits_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = RabbitApi()
        val repository = RabbitRepository(api)

        factory = RabbitsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(RabbitsViewModel::class.java)

        viewModel.getRabbits()

        RabbitApplication.database?.getRabbits()?.insertAll(

        )

        viewModel.movies.observe(viewLifecycleOwner, Observer { rabbits ->
            recycler_view_rabbit.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = RabbitsAdapter(rabbits, this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, rabbit: Rabbit) {
        when(view.id){
            R.id.cardView -> {
                Toast.makeText(requireContext(), "Item Clicked",Toast.LENGTH_LONG).show()
                val someFragment: Fragment = RabbitDetailFragment()
                val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
                transaction.replace(
                    R.id.fragment,
                    someFragment
                ) // give your fragment container id in first parameter
                transaction.addToBackStack(null) // if written, this transaction will be added to backstack
                transaction.commit()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
