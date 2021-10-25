package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private var bu_act_puls:Button? = null
    private var bu_act_sub:Button? = null

    private val REQUESTCODEPLUSR:Int = 1
    private val REQUESTCODESUB:Int = 2

    private var tv_result:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_result = findViewById(R.id.tv_result)

        bu_act_puls = findViewById(R.id.bu_act_plus)
        bu_act_sub = findViewById(R.id.bu_act_sub)



        val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == REQUESTCODEPLUSR)
            {
                tv_result!!.text = it.data?.getDoubleExtra("Result_plus" , 0.0).toString()
            }
            if (it.resultCode == REQUESTCODESUB)
            {
                tv_result!!.text = it.data?.getDoubleExtra("Result_sub" , 0.0).toString()
            }
        }

        bu_act_sub!!.setOnClickListener {
            val intent = Intent(this ,Activity_sub::class.java)

            getResult.launch(intent)
        }
        bu_act_puls!!.setOnClickListener {
            val intent = Intent(this ,Activity_plus::class.java)

            getResult.launch(intent)
        }

    }

}