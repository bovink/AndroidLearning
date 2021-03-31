package com.bovink.androidlearning

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

/**
 * @author bovink
 * @since 2021/3/31
 */
class PersonNameFragment : Fragment(R.layout.frag_person_name) {

    private val model: PersonViewModel by activityViewModels()

    lateinit var nameTextView: TextView
    lateinit var nextBtn: Button
    lateinit var previousBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView = view.findViewById(R.id.tv_name)
        nextBtn = view.findViewById(R.id.btn_next_person)
        nextBtn.setOnClickListener{
            model.index.value  = 1
        }
        previousBtn = view.findViewById(R.id.btn_previous_person)
        previousBtn.setOnClickListener{
            model.index.value  = 0
        }


        model.index.observe(viewLifecycleOwner, Observer {
            nameTextView.text = model.getCurrentName()
        })
    }



}