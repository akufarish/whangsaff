package com.example.whangsaff.fragments

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whangsaff.R
import com.example.whangsaff.adapters.CallsAdapter
import com.example.whangsaff.models.Calls
import java.time.LocalDate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var callsImage: ArrayList<Int>
private lateinit var callsNewArray: ArrayList<Calls>
private lateinit var callsName: ArrayList<String>
private lateinit var callsTime: ArrayList<String>
private var callsRecyclerView: RecyclerView? = null

/**
 * A simple [Fragment] subclass.
 * Use the [CallsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CallsFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    private fun initComponent() {
        callsRecyclerView = view?.findViewById(R.id.callsRecyclerView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
        dataInit()

        callsNewArray = arrayListOf<Calls>()
        getCallsData()
        callsRecyclerView?.adapter = CallsAdapter(callsNewArray)
    }

    private fun getCallsData() {
        for (i in callsImage.indices) {
            val calls = Calls(callsImage[i], callsName[i], callsTime[i])
            callsNewArray.add(calls)
        }
    }

    private fun dataInit() {
        callsImage = arrayListOf()
        callsName = arrayListOf()
        callsTime = arrayListOf()

        for (i in 1..2) {
            callsImage.add(R.drawable.pp)
            callsName.add("Farish")
            callsTime.add(LocalDate.now().toString())
        }
    }
}