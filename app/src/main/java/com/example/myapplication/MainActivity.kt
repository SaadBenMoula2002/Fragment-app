package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(), FragmentA.SendMessage {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewpager)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.add(FragmentA(), "Tab - 1")
        viewPagerAdapter.add(FragmentB(), "Tab - 2")
        viewPager.adapter = viewPagerAdapter
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }
    override fun sendData(message: String) {
        val tag = "android:switcher:${R.id.viewpager}:1"
        val f = supportFragmentManager.findFragmentByTag(tag) as FragmentB
        f.displayReceivedData(message)
    }

}

