package com.example.myapplication

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.architecture.BaseMvvmActivity
import com.example.myapplication.ui.main.MainViewModel
import com.example.myapplication.ui.main.SectionsPagerAdapter

class MainActivity : BaseMvvmActivity<MainViewModel>() {
    override val viewModelType = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }
}