package com.example.testtaskforpecodesoftware


import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import org.jetbrains.annotations.NotNull
import kotlin.random.Random

class MainActivity : FragmentActivity() {

    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter
    }

    fun minus(view: View){
       TODO()
    }

    fun notificationButton(view: View){
        val nid=1
        val intent = Intent(this,NumberFragment::class.java)
        intent.apply {
           flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            val intentaction = intent.action
            if (intentaction != null) {
                    viewPager.currentItem =adapter.getItemPosition( adapter.i)
            }
       }
        val pendingIntent = getActivity (applicationContext , 0, intent, 0)
        val builder = NotificationCompat.Builder(application.baseContext, NotificationApp.CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_stat_name)
            .setContentTitle("Notification ")
            .setContentText("Notification ${adapter.i}")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setContentIntent(pendingIntent)

        with(NotificationManagerCompat.from(application.baseContext)) {
            notify(nid, builder.build())
       }
    }
    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun plusButton(view: View) {
        adapter.i++
        adapter.createFragment(adapter.i)
        adapter.notifyDataSetChanged()
        viewPager.adapter = adapter
        viewPager.setBackgroundColor(Random.nextInt())
    }
}