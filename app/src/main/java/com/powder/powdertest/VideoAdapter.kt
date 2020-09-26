package com.powder.powdertest

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class VideoAdapter(activity: AppCompatActivity, private val items: List<VideoEntity>) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun createFragment(position: Int): Fragment {
        return VideoFragment().getInstance(items[position % items.count()])
    }
}
