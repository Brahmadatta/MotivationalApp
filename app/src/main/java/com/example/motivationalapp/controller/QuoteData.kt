package com.example.motivationalapp.controller

import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.example.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONException
import javax.security.auth.callback.Callback

class QuoteData {

    lateinit var quoteArrayList : ArrayList<Quote>


    fun getQuotes(callback: QuoteListAsyncResponse)
    {
        val url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"

        val quoteRequest = JsonArrayRequest(Request.Method.GET,url, {
                response: JSONArray ->
            try {

                for (i in 0 until response.length())
                {
                    var quoteObject = response.getJSONObject(i)
                    var quote = Quote(quoteObject.getString("quote"),quoteObject.getString("name"))

                    quoteArrayList.add(quote)
                }

            }catch (e : JSONException){e.printStackTrace()}

            callback.processFinished(quoteArrayList)

        }, {
                error -> try {

            Log.e("not_working","nooo")
        }catch (e : JSONException){
            e.printStackTrace()
        }

        })

        AppController.instance!!.addToRequestQueue(quoteRequest)
    }
}