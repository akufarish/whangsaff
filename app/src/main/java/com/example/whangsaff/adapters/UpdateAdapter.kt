package com.example.whangsaff.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whangsaff.R
import com.example.whangsaff.models.Updates

class UpdateAdapter(
    private val newList: ArrayList<Updates>
) : RecyclerView.Adapter<UpdateAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val updateImage: ImageView = itemView.findViewById(R.id.updateImageView)
        val updateTextview: TextView = itemView.findViewById(R.id.updateTextView)
        val updateNameTextView: TextView = itemView.findViewById(R.id.updateNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemList =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.status_item, parent,
                    false
                )

        return MyViewHolder(itemList)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.updateImage.setImageResource(currentItem.updateImage)
        holder.updateTextview.text = currentItem.updateTime
        holder.updateNameTextView.text = currentItem.updateName
    }
}