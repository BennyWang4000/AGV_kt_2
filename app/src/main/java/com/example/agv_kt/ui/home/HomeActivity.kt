package com.example.agv_kt.ui.home

import android.os.Bundle
import com.example.agv_kt.R
import com.example.agv_kt.base.BaseActivity
import com.example.agv_kt.databinding.ActivityHomeBinding
import com.example.agv_kt.ui.home.adapter.HomePagerAdapter
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding.viewModel = viewModel
        navigationBottomHome.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuScript -> viewpagerHome.currentItem = 0
                R.id.menuMap -> viewpagerHome.currentItem = 1
                R.id.menuDirections -> viewpagerHome.currentItem = 2
            }
            return@setOnNavigationItemSelectedListener false
        }

//        viewpagerHome.currentItem = 1

        viewpagerHome.adapter= HomePagerAdapter(viewModel, this)
    }

    override fun getLayoutId(): Int = R.layout.activity_home

}