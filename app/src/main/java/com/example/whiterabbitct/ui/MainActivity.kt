package com.example.whiterabbitct.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.whiterabbitct.R
import com.example.whiterabbitct.data.models.Rabbit
import com.example.whiterabbitct.ui.rabbit.RabbitDetailFragment
import com.example.whiterabbitct.ui.rabbit.RabbitsFragment


class MainActivity : AppCompatActivity(), RabbitsFragment.OnRabbitSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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
