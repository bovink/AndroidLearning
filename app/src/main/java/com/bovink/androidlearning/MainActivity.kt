package com.bovink.androidlearning

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.button2).setOnClickListener(){

            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            startActivity(intent)
        }
    }
}