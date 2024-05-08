package com.example.whangsaff.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.whangsaff.fragments.CallsFragment
import com.example.whangsaff.fragments.ChatFragment
import com.example.whangsaff.fragments.UpdatesFragment

class PageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> ChatFragment()
            1 -> UpdatesFragment()
            2 -> CallsFragment()
            else -> {
                ChatFragment()
            }
        }

        return fragment
    }

}