package com.bovink.androidlearning

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun gotoNormal(v: View) {
        val i = Intent(this, NormalSlideActivity::class.java)
        startActivity(i)
    }

    fun gotoTab(v: View) {
        val i = Intent(this, TabSlideActivity::class.java)
        startActivity(i)
    }
}