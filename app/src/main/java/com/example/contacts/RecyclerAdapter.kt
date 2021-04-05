package com.example.contacts

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecyclerAdapter(val context: Context, val data: MutableList<RowData>) : RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.icon.setImageResource(data[position].icon)
        holder.name.text = data[position].name
        holder.phone.text = data[position].phone
        holder.position.text = position.toString()

        holder.deleteBtn.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val icon : ImageView
        val name : TextView
        val phone : TextView
        val position : TextView
        val deleteBtn : Button

        init {
            icon = view.findViewById(R.id.icon)
            name = view.findViewById(R.id.name)
            phone = view.findViewById(R.id.phone)
            position = view.findViewById(R.id.position)
            deleteBtn = view.findViewById(R.id.remove_btn)

            view.setOnLongClickListener {
                deleteBtn.visibility = View.VISIBLE
                true
            }
        }

    }

}