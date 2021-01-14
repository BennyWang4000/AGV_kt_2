package com.example.agv_kt.ui.script.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_script_cmd.view.*

class ScriptViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val textCmdName: TextView= view.textScriptCmdItemName
}