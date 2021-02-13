package com.bovink.androidlearning

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit


/**
 * @author bovink
 * @since 2021/2/8
 */
class ExampleFragment : Fragment(R.layout.fragment_fire_missiles) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<Button>(R.id.button2)
        btn.setOnClickListener {
        }
    }

    fun useAnimation() {
        val fragment = TwoFragment(Person("ll"))
        parentFragmentManager.commit {
            setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out
            )

            replace(R.id.any_id_for_fragment, fragment)
            addToBackStack(null)
        }

    }
}