package it.mokabyte.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    var queue : RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        queue = Volley.newRequestQueue(this.applicationContext)
        
        val btcValueTextView = findViewById<View>(R.id.btcValue) as TextView
        queue!!.publishQuote("BTC", btcValueTextView)
    }
}
