package com.bovink.androidlearning

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

/**
 * @author bovink
 * @since 2021/2/16
 */
class MainFragment : Fragment(R.layout.frag_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btn = view.findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_wordDetailActivity)
        }
    }
}