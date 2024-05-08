package com.example.whangsaff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.whangsaff.adapters.PageAdapter
import com.example.whangsaff.fragments.CallsFragment
import com.example.whangsaff.fragments.ChatFragment
import com.example.whangsaff.fragments.UpdatesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var pageAdapter: PageAdapter
    private lateinit var viewPager2: ViewPager2

    private fun initComponent() {
        bottomNavigationView = findViewById(R.id.bottomNavBar)
        viewPager2 = findViewById(R.id.mainViewPager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(ChatFragment())

        initComponent()

        bottomNavigationView.setOnItemReselectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.chatsId -> {
                    viewPager2.setCurrentItem(0)
                }
                R.id.updatesId -> {
                    viewPager2.setCurrentItem(1)
                }
                R.id.callsId -> {
                    viewPager2.setCurrentItem(2)
                }
            }
        }

        pageAdapter = PageAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = pageAdapter
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFrame, fragment)
        fragmentTransaction.commit()
    }
}