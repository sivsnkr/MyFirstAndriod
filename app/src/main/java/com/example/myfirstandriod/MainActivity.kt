package com.example.myfirstandriod

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (findViewById<Button>(R.id.done_button)).setOnClickListener {
            addNickName(it)
        }
        (findViewById<TextView>(R.id.nickname_text)).setOnClickListener{
            updateNickname(it)
        }
    }

    private fun addNickName(view : View){
        val editText : EditText = findViewById(R.id.nickname_edit)
        val nicknameTextview : TextView = findViewById(R.id.nickname_text)
        nicknameTextview.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextview.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view : View){
        val editText : EditText = findViewById(R.id.nickname_edit)
        val doneButton : Button = findViewById(R.id.done_button)
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        editText.requestFocus()
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, 0)
    }
}