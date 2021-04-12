package com.dio.recyclerviewstudidio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rv_list: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        updatelist()
    }

    private fun bindViews() {
        rv_list.adapter = adapter
        rv_list.layoutManager = LinearLayoutManager(this)
    }

    private fun updatelist() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Octavio Portugal",
                    "(99)8888-8888",
                    "img.png"
                ),
                Contact(
                    "Octavio Portugal",
                    "(99)8888-8888",
                    "img.png"
                )
            )
        )
    }

    private fun showToas(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_1 -> {
                showToas("Exibindo item de menu 1")
                true
            }
            R.id.item_menu_2 -> {
                showToas("Exibindo item de menu 2")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}