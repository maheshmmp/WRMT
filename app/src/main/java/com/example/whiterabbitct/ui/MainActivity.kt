package com.example.whiterabbitct.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.whiterabbitct.R
import com.example.whiterabbitct.data.models.Rabbit
import com.example.whiterabbitct.ui.rabbit.RabbitDetailFragment
import com.example.whiterabbitct.ui.rabbit.RabbitDetailFragment.Companion.newInstance
import com.example.whiterabbitct.ui.rabbit.RabbitsFragment

class MainActivity : AppCompatActivity(), RabbitsFragment.OnRabbitSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onRabbitSelected(rabbit: Rabbit) {
        val detailsFragment =
            RabbitDetailFragment.newInstance(rabbit)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, detailsFragment, "RD")
            .addToBackStack(null)
            .commit()
    }
}
