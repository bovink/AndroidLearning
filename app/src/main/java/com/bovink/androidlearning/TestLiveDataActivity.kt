package com.bovink.androidlearning

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author bovink
 * @since 2021/3/16
 */
class TestLiveDataActivity : AppCompatActivity() {

    var mNumData: MutableLiveData<Int> = MutableLiveData()

    private lateinit var mDataTextView: TextView
    private lateinit var mAddNumBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_livedata)

        mDataTextView = findViewById(R.id.tv_livedata)

        val numObserver = Observer<Int> { newInt ->
            mDataTextView.text = newInt.toString()
        }

        mNumData.observe(this, numObserver)

        mAddNumBtn = findViewById(R.id.btn_add_num)
        mAddNumBtn.setOnClickListener {
            mNumData.value = 100
        }
    }
}