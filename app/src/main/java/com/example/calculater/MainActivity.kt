package com.example.calculater

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.ezylang.evalex.Expression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.bth_0).setOnClickListener { sendTextFields("0") }
        findViewById<TextView>(R.id.bth_1).setOnClickListener { sendTextFields("1") }
        findViewById<TextView>(R.id.bth_2).setOnClickListener { sendTextFields("2") }
        findViewById<TextView>(R.id.bth_3).setOnClickListener { sendTextFields("3") }
        findViewById<TextView>(R.id.bth_4).setOnClickListener { sendTextFields("4") }
        findViewById<TextView>(R.id.bth_5).setOnClickListener { sendTextFields("5") }
        findViewById<TextView>(R.id.bth_6).setOnClickListener { sendTextFields("6") }
        findViewById<TextView>(R.id.bth_7).setOnClickListener { sendTextFields("7") }
        findViewById<TextView>(R.id.bth_8).setOnClickListener { sendTextFields("8") }
        findViewById<TextView>(R.id.bth_9).setOnClickListener { sendTextFields("9") }
        findViewById<TextView>(R.id.bth_left_parenthesis).setOnClickListener { sendTextFields("(") }
        findViewById<TextView>(R.id.bth_right_parenthesis).setOnClickListener { sendTextFields(")") }
        findViewById<TextView>(R.id.bth_slashe).setOnClickListener { sendTextFields("/") }
        findViewById<TextView>(R.id.bth_multiply).setOnClickListener { sendTextFields("*") }
        findViewById<TextView>(R.id.bth_plus).setOnClickListener { sendTextFields("+") }
        findViewById<TextView>(R.id.bth_minus).setOnClickListener { sendTextFields("-") }
        findViewById<TextView>(R.id.bth_point).setOnClickListener { sendTextFields(".") }

        findViewById<TextView>(R.id.bth_AC).setOnClickListener {
            findViewById<TextView>(R.id.math_operation).text = ""
            findViewById<TextView>(R.id.result_text).text = ""
        }

        findViewById<TextView>(R.id.back_bql).setOnClickListener {
            var mathOption = findViewById<TextView>(R.id.math_operation).text
            val str = mathOption.toString()
            if (str.isNotEmpty()) mathOption = str.substring(0, str.length - 1)
            findViewById<TextView>(R.id.result_text).text = ""
        }



        findViewById<TextView>(R.id.equal_bql).setOnClickListener {
            try{
                val result = Expression(findViewById<TextView>(R.id.math_operation).text.toString()).evaluate()

                val number = result.numberValue
                val longRes = number.toLong()

                if (number.compareTo(java.math.BigDecimal(longRes)) == 0) {
                    findViewById<TextView>(R.id.result_text).text = longRes.toString()
                } else {
                    findViewById<TextView>(R.id.result_text).text = number.toString()
                }
            } catch (e:Exception){
                Log.d("Ошибка","сообщение: ${e.message}")
            }
        }

    }
        fun sendTextFields(str: String){
            val mathOperation = findViewById<TextView>(R.id.math_operation)
            mathOperation.append(str)
        }

}