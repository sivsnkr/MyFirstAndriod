package com.example.myfirstandriod

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myfirstandriod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = MyName("Shiv Shankar")

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
        binding.nicknameText.setOnClickListener{
            updateNickname(it)
        }
    }

    private fun addNickName(view : View){
        val editText : EditText = binding.nicknameEdit
        val nicknameTextview : TextView = binding.nicknameText
        binding.myName?.nickName = editText.text.toString()
        nicknameTextview.apply{
            visibility = View.VISIBLE
        }
        editText.visibility = View.GONE
        view.visibility = View.GONE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view : View){
        val editText : EditText = binding.nicknameEdit
        val doneButton : Button = binding.doneButton
        editText.apply{
            visibility = View.VISIBLE
            requestFocus()
        }
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, 0)
    }
}