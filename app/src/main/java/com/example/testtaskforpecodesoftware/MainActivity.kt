package com.example.testtaskforpecodesoftware


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import java.util.*
import kotlin.random.Random

class MainActivity : FragmentActivity() {

    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var fragment: NumberFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter


    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun plusButton(view: View){
        adapter.plus()
var i=1
//      supportFragmentManager.beginTransaction()
//            .add(android.R.id.content, NumberFragment(),"${adapter.plus()}").commit()

adapter.createFragment(5)
       viewPager.setBackgroundColor(Random.nextInt())

    }
}