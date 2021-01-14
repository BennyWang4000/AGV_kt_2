package com.example.agv_kt.ui.script

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agv_kt.R
import com.example.agv_kt.base.BaseFragment
import com.example.agv_kt.databinding.FragmentScriptBinding
import com.example.agv_kt.ui.script.adapter.ScriptRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_script.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class ScriptFragment: BaseFragment<FragmentScriptBinding>(){

    private val viewModel by viewModel<ScriptViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scriptListAdapter= ScriptRecyclerAdapter(viewModel)

        recyclerScriptList.apply {
            layoutManager = LinearLayoutManager(context).apply {
                orientation= RecyclerView.VERTICAL
            }
            adapter = scriptListAdapter
        }

        viewModel.paramList.observe(viewLifecycleOwner, Observer {
            scriptListAdapter.notifyDataSetChanged()
//            recyclerScriptList.adapter= scriptListAdapter
            Timber.d("SCRIPT LIST OBSERVE: $it")
        })

    }


    override fun setViewModelToBinding(binding: FragmentScriptBinding) {
        binding.viewModel= viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_script
}