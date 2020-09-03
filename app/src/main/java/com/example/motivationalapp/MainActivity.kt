package com.example.motivationalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motivationalapp.controller.QuoteData
import com.example.motivationalapp.controller.QuoteListAsyncResponse
import com.example.motivationalapp.controller.QuoteViewPagerAdapter
import com.example.motivationalapp.model.Quote
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   lateinit var quoteViewPagerAdapter : QuoteViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewPagerAdapter = QuoteViewPagerAdapter(supportFragmentManager,getFragments())

        viewpager.adapter = quoteViewPagerAdapter

    }


    private fun getFragments(): ArrayList<QuotesFragment> {

        // lateinit var fragmentList: ArrayList<QuotesFragment> // will not work
        val fragmentList = ArrayList<QuotesFragment>()
        QuoteData().getQuotes(object : QuoteListAsyncResponse {
            override fun processFinished(quotes: ArrayList<Quote>) {


                (0 until quotes.size).mapTo(fragmentList) {
                    QuotesFragment.newInstance(
                        quotes[it].quote,
                        quotes[it].author
                    )
                }
                quoteViewPagerAdapter.notifyDataSetChanged()


            }

        })

        return fragmentList

    }

}