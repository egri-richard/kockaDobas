package com.example.kockadobas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var kocka1img: ImageView
    private lateinit var kocka2img: ImageView
    private lateinit var scoreDisplay: TextView
    private lateinit var kocka1btn: Button
    private lateinit var kocka2btn: Button
    private lateinit var throwBtn: Button
    private lateinit var resetBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        kocka1img = findViewById(R.id.kocka1img)
        kocka2img = findViewById(R.id.kocka2img)
        scoreDisplay = findViewById(R.id.scoreDisplay)
        kocka1btn = findViewById(R.id.kocka1btn)
        kocka2btn = findViewById(R.id.kocka2btn)
        throwBtn = findViewById(R.id.throwBtn)
        resetBtn = findViewById(R.id.resetBtn)
    }
}