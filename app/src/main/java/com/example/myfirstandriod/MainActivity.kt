package com.example.myfirstandriod

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}
//        val countUpButton : Button = findViewById(R.id.count_up)
//        countUpButton.setOnClickListener{countUp()}
//        val resetButton : Button = findViewById(R.id.reset_button)
//        resetButton.setOnClickListener{resetValue()}

    }

    private fun rollDice(){
        val resultImageView : ImageView = findViewById(R.id.dice_image)
        val drawableResource = when((1..6).random()){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        resultImageView.setImageResource(drawableResource)
    }

//    private fun countUp(){
//        val resultText : TextView = findViewById(R.id.display_text)
//        val text = resultText.text.toString()
//        val finalText : String = if(text.isDigitsOnly()){
//            var value = text.toInt()
//            if(value < 6)
//                value++
//            value.toString()
//        }else{
//            "1"
//        }
//
//        resultText.text = finalText
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun resetValue(){
//        val resultText : TextView = findViewById(R.id.display_text)
//        resultText.text = "Hello World!"
//    }
}