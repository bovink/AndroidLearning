package com.bovink.androidlearning

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * @author bovink
 * @since 2021/3/18
 */
class NormalFragment : Fragment(R.layout.frag_normal) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {

            val someInt = requireArguments().getInt("some_int")
            view.findViewById<TextView>(R.id.textView2).text = someInt.toString()
        }
    }


}