package com.bovink.androidlearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bovink.androidlearning.databinding.FragMainBinding

/**
 * @author bovink
 * @since 2021/6/2
 */
class MainFragment : Fragment() {
    /**
     * 这样写不用每次都在binding后面写？来进行null判断
     * _binding只需要提供初始化和销毁即可
     */
    private var _binding: FragMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView2.text = "this is from fragment program"
        binding.button2.setOnClickListener{

            println("this is from fragment")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}