package com.bovink.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit

/**
 * @author bovink
 * @since 2021/3/18
 */
class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_normal)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val bundle = bundleOf("some_int" to 0)
                setReorderingAllowed(true)
                add<NormalFragment>(R.id.fragment2, args = bundle)
            }
        }
    }
}