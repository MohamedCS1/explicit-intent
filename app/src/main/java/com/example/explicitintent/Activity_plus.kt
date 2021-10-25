package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Activity_plus : AppCompatActivity() {

    private var ed_n1:EditText? = null
    var ed_n2:EditText? = null
    private val REQUESTCODEPLUSR:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plus)

        ed_n1 = findViewById(R.id.ed_plus_n1)
        ed_n2 = findViewById(R.id.ed_plus_n2)

    }
    override fun onBackPressed() {
        if (ed_n1!!.text.isNotEmpty() && ed_n2!!.text.isNotEmpty() )
        {
            setResult(REQUESTCODEPLUSR ,intent.putExtra("Result_plus" ,ed_n1?.text.toString().toDouble() + ed_n2?.text.toString().toDouble()))
        }
        super.onBackPressed()
    }


}