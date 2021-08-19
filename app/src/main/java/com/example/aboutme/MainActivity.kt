package com.example.aboutme

import android.content.Context


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var imm :InputMethodManager
    private lateinit var binding: ActivityMainBinding
    private var myName : MyName = MyName("Chen Yifen")
it 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneBtn.setOnClickListener {
            editNickName()
        }

    }

    private fun editNickName() {
        myName.nickname = binding.nickNameInput.text.toString()
        binding.myName = myName
        binding.nickNameInput.visibility = View.GONE
        binding.doneBtn.visibility = View.GONE
        binding.nickNameText.visibility = View.VISIBLE
        imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive){
            imm.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS)
        }

    }
}