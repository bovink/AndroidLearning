package com.bovink.androidlearning

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit


/**
 * @author bovink
 * @since 2021/2/8
 */
class ExampleFragment : Fragment(R.layout.fragment_fire_missiles) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemImageView = view.findViewById<ImageView>(R.id.imageView)
        ViewCompat.setTransitionName(itemImageView, "item_image")

        val btn = view.findViewById<Button>(R.id.button2)
        btn.setOnClickListener {
            val fragment = TwoFragment(Person("ll"))
            parentFragmentManager.commit {
                setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out
                )

                addSharedElement(itemImageView,"item_image2")
                replace(R.id.any_id_for_fragment, fragment)
                addToBackStack(null)
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            useTransition()
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun useTransition() {
        val inflater = TransitionInflater.from(context)
        exitTransition = inflater.inflateTransition(R.transition.fade)

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