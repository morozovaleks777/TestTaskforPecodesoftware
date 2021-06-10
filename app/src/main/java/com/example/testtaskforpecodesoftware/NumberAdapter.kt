package com.example.testtaskforpecodesoftware

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter


class NumberAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    lateinit var minusButton: Button
    var i =1
    fun getItemPosition(`object`: Any?): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = NumberFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position+1 )
        }

        return fragment
    }
fun getvisibility(view:View){
    minusButton=view.findViewById(R.id.minusButton2)
    if (i>1) minusButton.isVisible=true
}
    override fun getItemCount(): Int =i
}