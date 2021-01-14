package com.example.agv_kt.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.agv_kt.ui.home.HomeViewModel

class HomePagerAdapter(
    val viewModel: HomeViewModel,
    activity: FragmentActivity
) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment = viewModel.fragmentList[position]


}


