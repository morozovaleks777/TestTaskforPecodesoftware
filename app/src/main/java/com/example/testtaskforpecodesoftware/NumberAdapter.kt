package com.example.testtaskforpecodesoftware

import android.os.Bundle
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlin.properties.Delegates


class NumberAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    val fragments: MutableList<NumberFragment> = ArrayList()

var i =1
    override fun getItemCount(): Int =plus()

    override fun createFragment(position: Int): Fragment {

        val fragment = NumberFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position +1)
        }
        return fragment


    }

    fun plus( ):Int{

        i++

        return i
    }
}