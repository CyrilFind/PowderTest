package com.powder.powdertest

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class VideoAdapter(activity: AppCompatActivity, val items: List<Video>) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun createFragment(position: Int): Fragment {
        return VideoFragment().getInstance(items[position])
    }
}
