package com.example.difflistapp.adapter

import android.content.Context
import android.content.res.Resources.NotFoundException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.difflistapp.R
import com.example.difflistapp.model.NameWithImage
import com.example.difflistapp.model.StateAndCapital

class MyAdapter(private val context: Context, private val list: MutableList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val LAYOUT_ONE = 1
        private const val LAYOUT_TWO = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is StateAndCapital -> LAYOUT_ONE
            is NameWithImage -> LAYOUT_TWO
            else -> throw IllegalArgumentException("Invalid item type at position $position")
        }
    }

    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        var textView2: TextView = itemView.findViewById(R.id.textView2)
    }

    private class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
        var textView2: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var view: View
        val inflation = LayoutInflater.from(context)
        return when (viewType) {
            LAYOUT_ONE -> {
                view = inflation.inflate(R.layout.layout_one, parent, false)
                FirstViewHolder(view)
            }

            LAYOUT_TWO -> {
                view = inflation.inflate(R.layout.layout_two, parent, false)
                SecondViewHolder(view)
            }

            else -> throw NotFoundException("Layout Not Found")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position]) {
            is StateAndCapital -> {
                holder as FirstViewHolder
                holder.textView1.text = (list[position] as StateAndCapital).state
                holder.textView2.text = (list[position] as StateAndCapital).capital
            }

            is NameWithImage -> {
                holder as SecondViewHolder
                holder.imageView.setImageResource((list[position] as NameWithImage).image)
                holder.textView2.text = (list[position] as NameWithImage).name
            }
        }
    }
}