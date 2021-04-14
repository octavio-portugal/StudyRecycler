package com.dio.recyclerviewstudidio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dio.recyclerviewstudidio.DetailAcvity.Companion.EXTRA_CONTACT
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.core.content.edit as edit

class MainActivity : AppCompatActivity(), ClickItemContactListener {
    private val rv_list: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        fetchListContact()
        bindViews()

    }


    private fun fetchListContact(){
        val list = arrayListOf(
            Contact(
                "Rafaela Pereira",
                "(99)7777-7777",
                "img.png"
            ),
            Contact(
                "Octavio Portugal",
                "(99)8888-8888",
                "img.png"
            )
        )
        getInstanceSharedPreferences().edit {
            val json = Gson().toJson(list)
            putString("contacts", json)
        }
    }

    private fun getInstanceSharedPreferences(): SharedPreferences{
        return getSharedPreferences("br.com.recyclerviewstudiodio.PREFERENCES", Context.MODE_PRIVATE)
    }

    private fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar =  findViewById<Toolbar>(R.id.toolbar1)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun bindViews() {
        rv_list.adapter = adapter
        rv_list.layoutManager = LinearLayoutManager(this)
        updatelist()
    }

    private fun getListContacts(): List<Contact>{
        val list = getInstanceSharedPreferences().getString("contacts", "[]")
        val turnsType = object : TypeToken<List<Contact>>() {}.type
        return Gson().fromJson(list, turnsType)
    }

    private fun updatelist() {
        adapter.updateList(getListContacts())

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

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, DetailAcvity::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }
}