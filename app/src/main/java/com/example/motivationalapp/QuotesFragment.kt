package com.example.motivationalapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.fragment_quotes.*
import java.util.concurrent.ThreadLocalRandom

class QuotesFragment : Fragment() {


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_quotes, container, false)


        //creating views controlled by fragment
        val quoteText = view.findViewById<TextView>(R.id.quoteText)
        val byAuthor = view.findViewById<TextView>(R.id.byAuthor)
        val cardView = view.findViewById<CardView>(R.id.cardView)

        var quote = arguments!!.get("quote").toString()

        var author = arguments!!.get("author").toString()

        quoteText.text = quote
        byAuthor.text = author

        val colors = intArrayOf(R.color.blue_600,R.color.red_700,R.color.green_400,R.color.grey_800,R.color.yellow_900
            ,R.color.amber_800,R.color.light_blue_700,R.color.dark_purple_600,R.color.orange_800)

        cardView.setBackgroundResource(getRandomColor(colors))

        byAuthor.setTextColor(R.color.white)
        //byAuthor.setBackgroundColor(R.color.grey_50)

        return view
    }

    companion object {

        fun newInstance(quote: String, author: String): QuotesFragment {
            val fragment = QuotesFragment()
            val bundle = Bundle()
            bundle.putString("quote", quote)
            bundle.putString("author", author)
            fragment.arguments =
                bundle    //This is the way to pass data between fragment and Activities

            return fragment
        }
    }

    internal fun getRandomColor(colorArray : IntArray) : Int {
        var color : Int
        var quotesArrayLen = colorArray.size
        val randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLen)
        color = colorArray[randomNum]
        return color
    }

}