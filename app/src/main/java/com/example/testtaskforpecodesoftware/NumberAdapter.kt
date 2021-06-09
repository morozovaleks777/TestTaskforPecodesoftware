package com.example.testtaskforpecodesoftware

import android.accessibilityservice.GestureDescription
import android.app.Notification
import android.os.Bundle
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlin.properties.Delegates


class NumberAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    val fragments: MutableList<Int> = ArrayList()

var i =0


    override fun createFragment(position: Int): Fragment {

        val fragment = NumberFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position +1)
        }
       fragments.add(position)
        return fragment


    }

    override fun getItemCount(): Int =fragments.size+1
    fun plus( ):Int{

        i++

        return i
    }

}