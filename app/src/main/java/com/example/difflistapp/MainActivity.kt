package com.example.difflistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.difflistapp.adapter.MyAdapter
import com.example.difflistapp.model.NameWithImage
import com.example.difflistapp.model.StateAndCapital

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView
    private lateinit var list:MutableList<Any>
    private lateinit var adapter:MyAdapter
    private var position1:Int=12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        list= mutableListOf<Any>()
        list.add(StateAndCapital("Maharashtra","Mumbai"))
        list.add(NameWithImage("France",R.drawable.france))
        list.add(StateAndCapital("Telangana","Hyderabad"))
        list.add(NameWithImage("Argentina",R.drawable.argentina))
        list.add(StateAndCapital("Bihar","Patna"))
        list.add(NameWithImage("Canada",R.drawable.canada))
        list.add(StateAndCapital("Uttar Pradesh","Lucknow"))
        list.add(NameWithImage("Germany",R.drawable.germany))
        list.add(StateAndCapital("TamilNadu","Chennai"))
        list.add(NameWithImage("Netherlands",R.drawable.netherlands))
        list.add(StateAndCapital("Karnataka","Bengaluru"))
        list.add(NameWithImage("Turkey",R.drawable.turkey))
        adapter= MyAdapter(this,list)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }

    fun addItemInRecyclerView(view: View) {
        list.add(StateAndCapital("Maharashtra","Mumbai"))
        list.add(NameWithImage("France",R.drawable.france))
        list.add(StateAndCapital("Telangana","Hyderabad"))
        list.add(NameWithImage("Argentina",R.drawable.argentina))
        list.add(StateAndCapital("Bihar","Patna"))
        list.add(NameWithImage("Canada",R.drawable.canada))
        list.add(StateAndCapital("Uttar Pradesh","Lucknow"))
        list.add(NameWithImage("Germany",R.drawable.germany))
        list.add(StateAndCapital("TamilNadu","Chennai"))
        list.add(NameWithImage("Netherlands",R.drawable.netherlands))
        list.add(StateAndCapital("Karnataka","Bengaluru"))
        list.add(NameWithImage("Turkey",R.drawable.turkey))
        adapter.notifyItemChanged(position1)
        position1 += 12
    }

    fun removeItemFRomRecyclerView(view: View) {
        list.removeLast()
        position1-=1
        adapter.notifyItemChanged(position1)
    }
}