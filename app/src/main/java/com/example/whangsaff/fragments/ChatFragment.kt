package com.example.whangsaff.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.whangsaff.R
import com.example.whangsaff.adapters.ChatAdapter
import com.example.whangsaff.models.Chat
import java.time.LocalDate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private lateinit var chatArrayList: ArrayList<Chat>
private var chatRecyclerView: RecyclerView? = null
private lateinit var chatImage: ArrayList<Int>
private lateinit var chatName: ArrayList<String>
private lateinit var chat: ArrayList<String>
private lateinit var chatTime: ArrayList<String>
private var chatItem: ConstraintLayout? = null


class ChatFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun initComponent() {
        chatRecyclerView = view?.findViewById(R.id.chatRecyclerView)
        chatItem = view?.findViewById(R.id.chatLayout)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initComponent()
        dataInit()

        chatItem?.setOnClickListener {
            Toast.makeText(context, "Test", Toast.LENGTH_LONG)
            Log.d("Pressed", "Pressed!")
        }

        chatArrayList = arrayListOf<Chat>()
        getChatData()
        chatRecyclerView?.adapter = ChatAdapter(chatArrayList)
    }

    private fun dataInit() {
        chatImage = arrayListOf(
            R.drawable.pp,
            R.drawable.pp,
            R.drawable.pp,
        )

        chatName = arrayListOf(
            "apa coba",
            "apa coba",
            "apa coba",
        )

        chat = arrayListOf<String>(
            "BBM",
            "BBM",
            "BBM",
        )

        chatTime = arrayListOf<String>(
            LocalDate.now().toString(),
            LocalDate.now().toString(),
            LocalDate.now().toString(),
        )

        for (i in 1..10) {
            chatName.add(i.toString())
            chatImage.add(R.drawable.pp)
            chat.add(i.toString())
            chatTime.add(LocalDate.now().toString())
        }
    }

    private fun getChatData() {
        for (i in chatImage.indices) {
            val chat = Chat(chatImage[i], chatName[i], chat[i], chatTime[i])
            chatArrayList.add(chat)
        }
    }
}