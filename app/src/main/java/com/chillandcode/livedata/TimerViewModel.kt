package com.chillandcode.livedata

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {

    private lateinit var _timer: CountDownTimer
     var timerRunning:Boolean=false
    private val _seconds = MutableLiveData<Int>()
    val seconds: LiveData<Int> get() = _seconds

    fun startTimer() {
        timerRunning=true
        _timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(p0: Long) {
                val timeLeft = p0 / 1000
                _seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
                println("TIMER FINISHED")
                timerRunning=false
            }

        }.start()
    }

    fun stopTimer() {
        _timer.cancel()
    }
}