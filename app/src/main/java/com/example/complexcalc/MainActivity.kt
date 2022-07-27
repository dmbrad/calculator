package com.example.complexcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import javax.xml.xpath.XPathExpressionException
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//\\Numbers
        Txt_one.setOnClickListener { onclick("1", true) }
        Txt_two.setOnClickListener { onclick("2", true) }
        Txt_three.setOnClickListener { onclick("3", true) }
        Txt_four.setOnClickListener { onclick("4", true) }
        Txt_five.setOnClickListener { onclick("5", true) }
        Txt_six.setOnClickListener { onclick("6", true) }
        Txt_seven.setOnClickListener { onclick("7", true) }
        Txt_eight.setOnClickListener { onclick("8", true) }
        Txt_nine.setOnClickListener { onclick("9", true) }
        Txt_Zero.setOnClickListener { onclick("0", true) }
        Txt_Dot.setOnClickListener { onclick(".", true) }

//operators
        Txt_plus.setOnClickListener { onclick("+",false) }
        Txt_minus.setOnClickListener { onclick("-",false) }
        Txt_mul.setOnClickListener { onclick("*",false) }
        Txt_div.setOnClickListener { onclick("/",false) }
        Txt_open.setOnClickListener { onclick("(",false) }
        Txt_close.setOnClickListener { onclick(")",false) }
        Txt_Equal.setOnClickListener { onclick("=",false) }

      Txt_clear.setOnClickListener {
          TV_D.text=""
          TV_R.text=""
      }
        Txt_Back.setOnClickListener {
            val string=TV_D.text.toString()
            if (string.isNotEmpty()){
                TV_D.text=string.substring(0,string.length-1)
            }
            TV_R.text=""

        }

        Txt_Equal.setOnClickListener {
            try {
                val expression=ExpressionBuilder(TV_D.text.toString()).build()
                val result=expression.evaluate()
                val longresult=result.toLong()
                if (result == longresult.toDouble())
                    TV_R.text=longresult.toString()
                else
                    TV_R.text=result.toString()
                



            }catch (e:Exception){
                Log.d("Exception","message : " + e.message)

            }
        }




    }
    fun onclick( string: String, canClear : Boolean){

        if (TV_R.text.isNotEmpty()){
            TV_D.text=""
        }




        if (canClear){
            TV_R.text=""
            TV_D.append(string)
        }else{
            TV_D.append(TV_R.text)
            TV_D.append(string)
            TV_R.text=""
        }
    }

    }




