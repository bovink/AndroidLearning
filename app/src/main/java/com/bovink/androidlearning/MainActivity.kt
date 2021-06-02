package com.bovink.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bovink.androidlearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * 绑定的方式有很多种，根据实际选择
         */
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)
        /**
         * 访问绑定的数据对象
         */
        val person = Person("leil", 12)
        binding.user = person
        /**
         * 访问绑定的视图对象
         */
        binding.textView.text = "this is from program"

        binding.button.setOnClickListener {
            println("this is from activity program")
        }
    }
}