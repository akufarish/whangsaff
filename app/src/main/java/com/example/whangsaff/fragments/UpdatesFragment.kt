package com.example.whangsaff.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whangsaff.R
import com.example.whangsaff.adapters.UpdateAdapter
import com.example.whangsaff.models.Updates
import java.time.LocalDate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var updatesArrayList: ArrayList<Updates>
private lateinit var updateImage: ArrayList<Int>
private lateinit var updateName: ArrayList<String>
private lateinit var updateTime: ArrayList<String>
private var statusRecyclerView: RecyclerView? = null

/**
 * A simple [Fragment] subclass.
 * Use the [UpdatesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdatesFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_updates, container, false)
    }

    private fun initComponent() {
        statusRecyclerView = view?.findViewById(R.id.statusRecyclerView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponent()
        dataInit()

        updatesArrayList = arrayListOf<Updates>()
        getStatusData()
        statusRecyclerView?.adapter = UpdateAdapter(updatesArrayList)
    }

    private fun getStatusData() {
        for (i in updateImage.indices) {
            val status = Updates(updateImage[i], updateName[i], updateTime[i])
            updatesArrayList.add(status)
        }
    }

    private fun dataInit() {
        updateImage = arrayListOf(
            R.drawable.pp,
        )

        updateName = arrayListOf(
            "Farish"
        )

        updateTime = arrayListOf(
            LocalDate.now().toString()
        )
    }
}