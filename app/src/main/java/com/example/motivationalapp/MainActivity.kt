package com.example.motivationalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motivationalapp.controller.AppController
import com.example.motivationalapp.controller.QuoteData
import com.example.motivationalapp.controller.QuoteListAsyncResponse
import com.example.motivationalapp.controller.QuoteViewPagerAdapter
import com.example.motivationalapp.model.Quote
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

   lateinit var quoteViewPagerAdapter : QuoteViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewPagerAdapter = QuoteViewPagerAdapter(supportFragmentManager,getFragments())

        viewpager.adapter = quoteViewPagerAdapter

    }


    fun getFragments() : ArrayList<QuotesFragment> {
       lateinit var fragmentList : ArrayList<QuotesFragment>

        QuoteData().getQuotes(object : QuoteListAsyncResponse{
            override fun processFinished(quotes: ArrayList<Quote>) {
                for (i in 0..quotes.size)
                {
                    var quoteFragment = QuotesFragment().newInstance(quotes[i].quote,
                                                quotes[i].author)
                    fragmentList.add(quoteFragment)
                }

                quoteViewPagerAdapter.notifyDataSetChanged()

            }
        })
        return fragmentList
    }

}