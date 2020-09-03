package com.example.motivationalapp.controller

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.example.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONException

class QuoteData {
    //private lateinit var quoteArrayList: ArrayList<Quote>
    private val quoteArrayList = ArrayList<Quote>()

    //val movies = ArrayList<Movie>()

    fun getQuotes(callback: QuoteListAsyncResponse) {
        val url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"

        val quoteRequest = JsonArrayRequest(Request.Method.GET, url, Response.Listener { response: JSONArray ->
            try {

                (0 until response.length())
                    .map { response.getJSONObject(it) }
                    .mapTo(quoteArrayList) { Quote(it.getString("quote"), it.getString("name")) }


            } catch (e: JSONException) {
                e.printStackTrace()
            }
            callback.processFinished(quoteArrayList) // very important

        }, Response.ErrorListener { _: VolleyError ->
            try {
                Log.d("Error", "Not working")

            } catch (e: JSONException) {
                e.printStackTrace()
            }
        })

        AppController.instance!!.addToRequestQueue(quoteRequest)


    }
}