package com.example.testtaskforpecodesoftware


import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
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
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat


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
    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun plusButton(view: View){
     var  i= adapter.fragments.size

      // adapter.plus()
        adapter.createFragment(i) as NumberFragment
        adapter.notifyDataSetChanged()

        viewPager.adapter = adapter

//      supportFragmentManager.beginTransaction()
//         .add(android.R.id.content, NumberFragment(),"").commit()
//        adapter.notifyDataSetChanged()
//        viewPager.setBackgroundColor(Random.nextInt())

    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun minusButton(view: View){
// Create an explicit intent for an Activity in your app
        val intent = Intent(this, NumberFragment::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this,"2")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("Hello World!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
    }
}