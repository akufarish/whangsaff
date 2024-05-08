package com.example.whangsaff.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whangsaff.R
import com.example.whangsaff.models.Chat

class ChatAdapter(
    private val newList: ArrayList<Chat>
) : RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chatImage: ImageView = itemView.findViewById(R.id.chatImageView)
        val chatName: TextView = itemView.findViewById(R.id.chatNameTextView)
        val chat: TextView = itemView.findViewById(R.id.chatTextView)
        val chatTime: TextView = itemView.findViewById(R.id.chatTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.chat_item, parent, false
                )

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.chatImage.setImageResource(currentItem.chatImage)
        holder.chatName.text = currentItem.chatName
        holder.chat.text = currentItem.chat
        holder.chatTime.text = currentItem.time
    }
}