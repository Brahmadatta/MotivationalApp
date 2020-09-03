package com.example.motivationalapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_quotes.*

class QuotesFragment : Fragment() {


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_quotes, container, false)

        var quote = arguments!!.get("quote").toString()

        var author = arguments!!.get("author").toString()

        quoteText.text = quote
        byAuthor.text = author

        cardView.setBackgroundResource(Color.parseColor("Yellow"))

        return view
    }


    fun newInstance(quote : String,author : String) : QuotesFragment{
        val fragment = QuotesFragment()
        val bundle = Bundle()
        bundle.putString("quote",quote)
        bundle.putString("author",author)
        fragment.arguments = bundle    //This is the way to pass data between fragment and Activities

        return fragment
    }
}