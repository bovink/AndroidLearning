package com.bovink.androidlearning

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoNormal(v: View) {

        val intent = Intent(this, NormalActivity::class.java)
        startActivity(intent)
    }

    fun gotoViewModel(v: View) {

        val intent = Intent(this, ViewModelActivity::class.java)
        startActivity(intent)
    }

    fun gotoPersonInfo(v: View) {

        val intent = Intent(this, PersonInfoActivity::class.java)
        startActivity(intent)
    }

}