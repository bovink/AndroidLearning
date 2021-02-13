package com.bovink.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

/**
 * @author bovink
 * @since 2021/2/8
 */
class ShowFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_fragment)

        supportFragmentManager.commit {

            val fragment = TwoFragment(Person("ll"))
            add(R.id.any_id_for_fragment,fragment)
            setReorderingAllowed(false)
            addToBackStack("")
        }
    }
}