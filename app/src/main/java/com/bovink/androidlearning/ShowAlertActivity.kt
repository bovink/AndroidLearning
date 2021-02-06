package com.bovink.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author bovink
 * @since 2021/2/6
 */
class ShowAlertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showalert)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .add(R.id.fragment, FireMissilesDialogFragment())
//                    .commit()
//        }
        FireMissilesDialogFragment().show(supportFragmentManager,"")

    }
}