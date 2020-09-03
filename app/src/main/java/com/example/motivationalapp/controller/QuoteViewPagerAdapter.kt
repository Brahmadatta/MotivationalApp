package com.example.motivationalapp.controller

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.motivationalapp.QuotesFragment

class QuoteViewPagerAdapter(fragmentManager: FragmentManager, fragments: ArrayList<QuotesFragment>) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var fragmentList : ArrayList<QuotesFragment> = fragments

    override fun getItem(position: Int): Fragment {
        return this.fragmentList[position]
    }

    override fun getCount(): Int {
        return this.fragmentList.size
    }
}