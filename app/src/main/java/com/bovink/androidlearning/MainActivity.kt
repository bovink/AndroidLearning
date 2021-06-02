package com.bovink.androidlearning

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn_enter)
        btn.setOnClickListener {
            enterCommonViewActivity()
        }

    }

    fun enterCommonViewActivity() {
        val intent = Intent(this, CommonViewActivity::class.java)
        startActivity(intent)
    }
}