package com.example.whangsaff.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whangsaff.R
import com.example.whangsaff.models.Calls

class CallsAdapter(
    private val newList: ArrayList<Calls>
) : RecyclerView.Adapter<CallsAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val callsImage: ImageView = itemView.findViewById(R.id.callsImageView)
        val callsName: TextView = itemView.findViewById(R.id.callNameTextView)
        val callsTime: TextView = itemView.findViewById(R.id.callTimeTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val newItem =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.calls_item, parent, false)

        return MyViewHolder(newItem)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.callsImage.setImageResource(currentItem.callsImage)
        holder.callsName.text = currentItem.callsName
        holder.callsTime.text = currentItem.callsTime
    }

}