package com.bovink.androidlearning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author bovink
 * @since 2021/2/15
 */
class NameAdapter(private val dataSet: Array<String>) : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.textView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_name, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return dataSet.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       holder.textView.text = dataSet[position]
    }
}