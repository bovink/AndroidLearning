package com.bovink.androidlearning

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

/**
 * @author bovink
 * @since 2021/3/17
 */
class ViewModelActivity : AppCompatActivity() {

    lateinit var tv: TextView
    val model: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_viewmodel)

        tv = findViewById(R.id.tv_viewmodel)
        tv.text = model.num.toString()
    }

    fun addNum(v: View) {
        model.num++
        tv.text = model.num.toString()
    }

}