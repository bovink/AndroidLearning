package com.bovink.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bovink.androidlearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        viewBinding.textView.text = "this is from program"
        viewBinding.button.setOnClickListener {
            println("click btn")
        }
    }
}