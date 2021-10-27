package com.example.testtaskforpecodesoftware


    import android.annotation.SuppressLint

    import android.os.Bundle
    import androidx.fragment.app.Fragment

    import androidx.fragment.app.FragmentActivity
    import androidx.fragment.app.FragmentManager
    import androidx.lifecycle.Lifecycle
    import androidx.viewpager2.adapter.FragmentStateAdapter


    class MyAdapter : FragmentStateAdapter {
        companion object {
            var i = 1
        }

        lateinit var fragment: BlankFragment
        var mFragmentList: MutableList<Fragment>

        internal constructor(fragmentActivity: FragmentActivity) : super(fragmentActivity) {
            mFragmentList = ArrayList()
        }



        @SuppressLint("NotifyDataSetChanged")
        fun addFragment(fragment: BlankFragment) {
            fragment.arguments = Bundle().apply {
                putInt(ARG_OBJECT, i)
            }
            mFragmentList.add(fragment)
            notifyDataSetChanged()
        }

        @SuppressLint("NotifyDataSetChanged")
        fun removeFragment() {
            if (mFragmentList.size >1) {
                mFragmentList. removeAt(mFragmentList.size-1 )
                 i--
                notifyDataSetChanged()
            }
        }

        override fun createFragment(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getItemCount(): Int {
            return mFragmentList.size
        }
}