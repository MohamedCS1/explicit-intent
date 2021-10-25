package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Activity_sub : AppCompatActivity() {

    var ed_n1: EditText? = null
    var ed_n2: EditText? = null
    private val REQUESTCODESUB:Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        ed_n1 = findViewById(R.id.ed_sub_n1)
        ed_n2 = findViewById(R.id.ed_sub_n2)
    }

    override fun onBackPressed() {
        if (ed_n1!!.text.isNotEmpty() && ed_n2!!.text.isNotEmpty() )
        {
            setResult(REQUESTCODESUB ,intent.putExtra("Result_sub" ,ed_n1?.text.toString().toDouble() - ed_n2?.text.toString().toDouble()))
        }
        super.onBackPressed()
    }
}