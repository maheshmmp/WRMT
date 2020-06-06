package com.example.whiterabbitct.ui.rabbit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.whiterabbitct.R
import com.example.whiterabbitct.data.models.Rabbit
import com.example.whiterabbitct.databinding.RecyclerviewRabbitBinding

class RabbitsAdapter (
    private val rabbits: List<Rabbit>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<RabbitsAdapter.RabbitsViewHolder>(){

    override fun getItemCount() = rabbits.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RabbitsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_rabbit,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RabbitsViewHolder, position: Int) {
        holder.recyclerviewRabbitBinding.rabbit = rabbits[position]
        holder.recyclerviewRabbitBinding.cardView.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewRabbitBinding.cardView, rabbits[position])
        }
        holder.setData(rabbits[position])
    }

    inner class RabbitsViewHolder(
        val recyclerviewRabbitBinding: RecyclerviewRabbitBinding
    ) : RecyclerView.ViewHolder(recyclerviewRabbitBinding.root){
        fun setData(rabbit: Rabbit) {
            recyclerviewRabbitBinding.rabbit = rabbit
        }
    }

}