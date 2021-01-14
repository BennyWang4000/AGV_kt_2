package com.example.agv_kt.ui.script.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agv_kt.R
import com.example.agv_kt.ui.script.ScriptViewModel
import timber.log.Timber

class ScriptRecyclerAdapter(
        val viewModel: ScriptViewModel
): RecyclerView.Adapter<ScriptViewHolder>() {

    private var cmdList: List<ScriptItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScriptViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
                R.layout.item_script_cmd,
                parent,
                false)
        return ScriptViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScriptViewHolder, position: Int) {
        viewModel.paramList.value?.let {
            val currentCmd= it[position]
            Timber.d("POSITION: $position, CMD NAME: ${currentCmd.Command}")
            holder.textCmdName.text= currentCmd.Command
        }
    }

    override fun getItemCount(): Int{
        viewModel.paramList.value?.let {
//            Timber.d("SCRIPT LIST SIZE: ${it.size}")
            return it.size
        }
        return 0
    }

}