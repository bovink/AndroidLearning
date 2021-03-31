package com.bovink.androidlearning

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

/**
 * @author bovink
 * @since 2021/3/31
 */
class PersonInfoActivity : AppCompatActivity() {

    val viewModel: PersonViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_personinfo)

    }
}