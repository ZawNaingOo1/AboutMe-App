package com.neona.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.neona.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName= MyName("Zaw G")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener { addNickName(it) }
        binding.nicknameText.setOnClickListener { updateNickName(it) }

    }

    private fun addNickName(view: View){

        binding.apply {
            binding.myName?.nickname = binding.nicknameEdit.text.toString()
            invalidateAll()
            binding.doneButton.visibility = View.GONE
            binding.nicknameEdit.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateNickName(view: View){

        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        binding.nicknameEdit.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit,0)
        
    }
}