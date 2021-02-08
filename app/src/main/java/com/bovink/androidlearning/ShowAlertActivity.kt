package com.bovink.androidlearning

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
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
        FireMissilesDialogFragment().show(supportFragmentManager, "")

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        return false;
    }
}