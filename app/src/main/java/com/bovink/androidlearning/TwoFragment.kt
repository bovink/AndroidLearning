package com.bovink.androidlearning

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

/**
 * @author bovink
 * @since 2021/2/13
 */
class TwoFragment(val p: Person) : Fragment(R.layout.frag_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hero_image = view.findViewById<ImageView>(R.id.imageView2)
        ViewCompat.setTransitionName(hero_image, "item_image2")

        val btn = view.findViewById<Button>(R.id.button)
        btn.setText(p.getName())
        btn.setOnClickListener {
            Toast.makeText(context, "two", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            useTransition()
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun useTransition() {
//        val inflater = TransitionInflater.from(context)
//        enterTransition = inflater.inflateTransition(R.transition.slder_right)

        sharedElementEnterTransition = TransitionInflater.from(requireContext())
                .inflateTransition(R.transition.shared_image)
    }


}