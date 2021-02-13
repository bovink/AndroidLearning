package com.bovink.androidlearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

/**
 * @author bovink
 * @since 2021/2/13
 */
class TwoFragment(val p: Person) : Fragment(R.layout.frag_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<Button>(R.id.button)
        btn.setText(p.getName())
        btn.setOnClickListener {
            Toast.makeText(context, "two", Toast.LENGTH_SHORT).show()

        }
    }

}