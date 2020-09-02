package com.example.motivationalapp.controller

import com.example.motivationalapp.model.Quote

class QuoteData {

    lateinit var quoteArrayList : ArrayList<Quote>


    fun getQuotes()
    {
        val url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"
    }
}