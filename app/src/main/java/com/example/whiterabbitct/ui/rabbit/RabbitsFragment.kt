package com.example.whiterabbitct.ui.rabbit

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whiterabbitct.R
import com.example.whiterabbitct.data.models.Rabbit
import com.example.whiterabbitct.data.network.RabbitApi
import com.example.whiterabbitct.repositories.RabbitRepository
import kotlinx.android.synthetic.main.rabbits_fragment.*


class RabbitsFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var factory: RabbitsViewModelFactory
    private lateinit var viewModel: RabbitsViewModel

    private var searchView: SearchView? = null
    private var queryTextListener: SearchView.OnQueryTextListener? = null

    private lateinit var listener: OnRabbitSelected

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rabbits_fragment, container, false)
    }

    companion object {
        fun newInstance(): RabbitsFragment {
            return RabbitsFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnRabbitSelected) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnRabbitSelected.")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = RabbitApi()
        val repository = RabbitRepository(api)
        factory = RabbitsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(RabbitsViewModel::class.java)
        viewModel.getRabbits()
        viewModel.rabbitLiveDataList.observe(viewLifecycleOwner, Observer { rabbits ->
            recycler_view_rabbit.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = RabbitsAdapter(rabbits, this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, rabbit: Rabbit) {
        when (view.id) {
            R.id.cardView -> {
                listener.onRabbitSelected(rabbit)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search, menu)
        val searchItem = menu.findItem(R.id.app_bar_search)
        val searchManager =
            activity!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        if (searchItem != null) {
            searchView = searchItem.actionView as SearchView
        }
        if (searchView != null) {
            searchView!!.setSearchableInfo(searchManager.getSearchableInfo(activity!!.componentName))
            queryTextListener = object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String?): Boolean {
                    Log.i("onQueryTextChange", newText)
                    return true
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.i("onQueryTextSubmit", query)
                    return true
                }
            }
            searchView!!.setOnQueryTextListener(queryTextListener)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_search ->                 // Not implemented here
                return false
            else -> {
            }
        }
        searchView?.setOnQueryTextListener(queryTextListener)
        return super.onOptionsItemSelected(item)
    }

    interface OnRabbitSelected {
        fun onRabbitSelected(rabbit: Rabbit)
    }
}
