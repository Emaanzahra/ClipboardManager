package com.example.clipboardmanager

import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.clipboardmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            updateClibBoard()
        }
    }

    fun updateClibBoard(){
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = clipboard.primaryClip
        if (clipData != null && clipData.itemCount > 0){
            val item = clipData.getItemAt(0)
            if (item.text != null){
                val cliptext = item.text
                binding.txtView.text = cliptext
            }
            else if(item.uri != null){
                val imageURI = item.uri
                binding.imageView.setImageURI(imageURI)
            }
            else{
                binding.txtView.text = "Clipboard is empty"
            }
        }

    }
}