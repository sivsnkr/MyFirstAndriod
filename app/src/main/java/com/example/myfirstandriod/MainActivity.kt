package com.example.myfirstandriod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById<Button>(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}
        val countUpButton : Button = findViewById(R.id.count_up)
        countUpButton.setOnClickListener{countUp()}
        val resetButton : Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener{resetValue()}

    }

    private fun rollDice(){
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
        val resultText : TextView = findViewById<TextView>(R.id.display_text)
        val randomFace = (1..6).random()
        resultText.text = randomFace.toString()
    }

    private fun countUp(){
        val resultText : TextView = findViewById(R.id.display_text)
        val text = resultText.text.toString()
        val finalText : String = if(text.isDigitsOnly()){
            var value = text.toInt()
            if(value < 6)
                value++
            value.toString()
        }else{
            "1"
        }

        resultText.text = finalText
    }

    private fun resetValue(){
        val resultText : TextView = findViewById(R.id.display_text)
        resultText.text = "Hello World!"
    }
}