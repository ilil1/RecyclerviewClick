package com.project.recyclerviewclick

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Model>()
        for(i: Int in 1..10) {
            var contact = Model("Add ", i.toString(), "https://picsum.photos/200")
            list.add(contact)
        }

        recyclerview = findViewById(R.id.recyclerView)

        adapter = RecyclerAdapter(list)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        adapter.setItemClickListener(object: RecyclerAdapter.ClickListener {
            override fun onClick(v: View, position: Int) {
                // ClickListener 작성
                Toast.makeText(this@MainActivity,
                    "${list[position].content}",
                    Toast.LENGTH_SHORT).show()
            }
        })
    }
}