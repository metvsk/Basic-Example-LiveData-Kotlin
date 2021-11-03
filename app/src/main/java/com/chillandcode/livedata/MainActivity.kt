package com.chillandcode.livedata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    private lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("MAIN ACTIVITY RAN")
        tv = findViewById<TextView>(R.id.timerTextView)

        val viewModel = ViewModelProvider(this).get(TimerViewModel::class.java)

        if (!viewModel.timerRunning)
            viewModel.startTimer()


        // here we are observing the mutable live data in the view model and if there are any changes in data the data the following codes will be executed

        viewModel.seconds.observe(this, {
            println("OBSERVER CALLED")
            tv.text = it.toString()
        })

    }

}