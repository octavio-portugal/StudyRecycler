package com.dio.recyclerviewstudidio

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailAcvity :AppCompatActivity(){

    private var contact: Contact? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)

        getExtras()
        bindViews()
        initToolbar()
    }

    private fun initToolbar(){
        val toolbar =  findViewById<Toolbar>(R.id.toolbar1)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindViews(){
        findViewById<TextView>(R.id.tv_name_details).text = contact?.name
        findViewById<TextView>(R.id.tv_phone_details).text = contact?.phone

    }

    companion object {
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}