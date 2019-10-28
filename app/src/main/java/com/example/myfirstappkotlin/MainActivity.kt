package com.example.myfirstappkotlin

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

    class MainActivity : AppCompatActivity() {
        private var mediaPlayer: MediaPlayer? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            mediaPlayer = MediaPlayer.create(this, R.raw.fairy)
            mediaPlayer?.start()
        }

        fun sendMessage(view: View) {
            val editText = findViewById<EditText>(R.id.editText)
            val message = editText.text.toString()
            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }

    }
