package com.example.whangsaff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.whangsaff.fragments.CallsFragment
import com.example.whangsaff.fragments.ChatFragment
import com.example.whangsaff.fragments.UpdatesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    private fun initComponent() {
        bottomNavigationView = findViewById(R.id.bottomNavBar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(ChatFragment())

        initComponent()

        bottomNavigationView.setOnItemReselectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.chatsId -> {
                    replaceFragment(ChatFragment())
                }
                R.id.updatesId -> {
                    replaceFragment(UpdatesFragment())
                }
                R.id.callsId -> {
                    replaceFragment(CallsFragment())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFrame, fragment)
        fragmentTransaction.commit()
    }
}