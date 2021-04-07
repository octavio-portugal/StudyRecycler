package com.dio.recyclerviewstudidio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rv_list:RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        updatelist()
    }

    private fun bindViews(){
        rv_list.adapter = adapter
        rv_list.layoutManager = LinearLayoutManager(this)
    }

    private fun updatelist(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Octavio Portugal",
                    "(99)8888-8888",
                    "img.png"
                ) ,
                        Contact(
                        "Octavio Portugal",
                "(99)8888-8888",
                "img.png"
            )
            )
        )
    }
}