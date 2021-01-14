package com.example.agv_kt.ui.directors

import android.os.Bundle
import android.view.View
import com.example.agv_kt.R
import com.example.agv_kt.base.BaseFragment
import com.example.agv_kt.databinding.FragmentDirectorsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DirectorsFragment: BaseFragment<FragmentDirectorsBinding>() {

    private val viewModel by viewModel<DirectorsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun setViewModelToBinding(binding: FragmentDirectorsBinding) {
        binding.viewModel = viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_directors
}