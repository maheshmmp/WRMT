package com.example.whiterabbitct.ui.rabbit

import android.view.View
import com.example.whiterabbitct.data.models.Rabbit

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, rabbit: Rabbit)
}