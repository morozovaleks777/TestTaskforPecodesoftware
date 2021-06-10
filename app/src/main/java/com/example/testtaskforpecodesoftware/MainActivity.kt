package com.example.testtaskforpecodesoftware


import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.testtaskforpecodesoftware.NumberAdapter.Companion.i
import kotlin.random.Random

const val INTENT_EXTRA_NOTIFICATION = "noti"

class MainActivity : FragmentActivity() {
    private lateinit var adapter: NumberAdapter
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter


    }
//    override fun onResume() {
//        super.onResume()
//
//        // Test if a Notification caused this activity to launch - if so then select the first tab
//        // NOTE: we get here from a notification by using Intent.FLAG_ACTIVITY_NEW_TASK
//        val extras = intent.extras
//        if (extras != null) {
//            val bIsLaunchedFromNotification = extras.getBoolean(INTENT_EXTRA_NOTIFICATION)
//            if (bIsLaunchedFromNotification) {
//                viewPager.setCurrentItem(extras.getInt(INTENT_EXTRA_NOTIFICATION), false)
//            }
//        }
//    }

    fun minus(view: View) {
        with(NotificationManagerCompat.from(this))
        { cancel(adapter.getItemId(viewPager.currentItem + 1).toInt()) }
        // viewPager.setCurrentItem(adapter.getItemId(viewPager.currentItem+1).toInt(), false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun notificationButton(view: View) {
        val intent = Intent(this, FragmentActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = getActivity(this, 0, intent, 0)
        //   val intent = Intent(this,MainActivity::class.java)
        //    intent.putExtra(INTENT_EXTRA_NOTIFICATION,adapter.getItemPosition(adapter.getItemId(viewPager.currentItem+1)))
//        intent.apply {
//           flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//            val intentaction = intent.action
//            if (intentaction != null) {
//                viewPager.setCurrentItem(adapter.getItemId(viewPager.currentItem+1).toInt(), false)
//            }
//       }
        // val pendingIntent = getActivity (applicationContext , 0, intent, FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(
            application.baseContext,
            NotificationApp.CHANNEL_1_ID
        )
            .setSmallIcon(R.drawable.ic_stat_name)
            .setContentTitle("Notification ")
            .setContentText("Notification ${adapter.getItemId(viewPager.currentItem + 1)}")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setContentIntent(pendingIntent)

        with(NotificationManagerCompat.from(this)) {
            notify(adapter.getItemId(viewPager.currentItem + 1).toInt(), builder.build())
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun plusButton(view: View) {
        i++
        adapter.createFragment(i)
        adapter.notifyDataSetChanged()
        viewPager.setBackgroundColor(Random.nextInt())

    }
}