package com.example.motivationalapp.controller

import com.example.motivationalapp.model.Quote

interface QuoteListAsyncResponse {

    fun processFinished(quotes : ArrayList<Quote>)
}