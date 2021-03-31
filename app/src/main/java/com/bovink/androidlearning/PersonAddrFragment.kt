package com.bovink.androidlearning

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

/**
 * @author bovink
 * @since 2021/3/31
 */
class PersonAddrFragment :Fragment(R.layout.fragment_person_addr) {

    private val model: PersonViewModel by activityViewModels()

    lateinit var addrTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addrTextView = view.findViewById(R.id.tv_addr)

        model.index.observe(viewLifecycleOwner, Observer {
            addrTextView.text = model.getCurrentAddr()
        })
    }

}