package it.mokabyte.testkotlin

import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest

fun RequestQueue.publishQuote(symbol: String, textView: TextView) {

    val jsonObjectRequest = JsonArrayRequest(Request.Method.GET,
            "https://api.coinmarketcap.com/v1/ticker/?limit=20",
            null,
            Response.Listener { response ->
                for (i in 0..(response.length() - 1)) {
                    val quote = response.getJSONObject(i)
                    if (quote.getString("symbol") == symbol.toUpperCase())
                        textView.text = quote.getString("price_usd") + " USD"
                }
            },
            Response.ErrorListener { error ->
                Log.v("PUBLISH_QUOTE", error.toString())
            }
    )

    this.add(jsonObjectRequest)
}
