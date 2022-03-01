package com.boxma.gamer.formydearfriend.presentation

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import com.boxma.gamer.formydearfriend.core.BaseActivity
import com.boxma.gamer.formydearfriend.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var timer: CountDownTimer? = null

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI() {
        binding.button.setOnClickListener { createTimer(46000) }
        binding.button2.setOnClickListener { timer?.cancel() }
    }

    private fun createTimer(seconds: Long){
        timer =  object : CountDownTimer(seconds, 1000) {
            override fun onTick(p0: Long) {
                binding.textView.text = "${p0/ 1000}"
            }
            override fun onFinish() {
                binding.textView.text = "Finish"
            }
        }.start()
    }
}