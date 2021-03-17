package com.bovink.androidlearning

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * @author bovink
 * @since 2021/3/17
 */
class NormalActivity : AppCompatActivity() {

    lateinit var tv: TextView
    var num: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_normal)

        tv = findViewById(R.id.tv_normal)
        tv.text = num.toString()
    }

    fun addNum(v: View) {
        num++;
        tv.text = num.toString()
    }

}