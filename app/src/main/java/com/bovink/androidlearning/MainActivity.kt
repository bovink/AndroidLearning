package com.bovink.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rec = findViewById<RecyclerView>(R.id.recyclerview)

        rec.layoutManager = LinearLayoutManager(this)
        val adapter = NameAdapter(arrayOf("10", "20", "30"))
        rec.adapter = adapter
    }
}