package com.example.kockadobas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var kocka1img: ImageView
    private lateinit var kocka2img: ImageView
    private lateinit var scoreDisplay: TextView
    private lateinit var kocka1btn: Button
    private lateinit var kocka2btn: Button
    private lateinit var throwBtn: Button
    private lateinit var resetBtn: Button
    private lateinit var rnd: Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        kocka1btn.setOnClickListener {
            kocka2img.visibility = View.GONE
        }

        kocka2btn.setOnClickListener {
            kocka2img.visibility = View.VISIBLE
        }
    }

    private fun init() {
        kocka1img = findViewById(R.id.kocka1img)
        kocka2img = findViewById(R.id.kocka2img)
        scoreDisplay = findViewById(R.id.scoreDisplay)
        kocka1btn = findViewById(R.id.kocka1btn)
        kocka2btn = findViewById(R.id.kocka2btn)
        throwBtn = findViewById(R.id.throwBtn)
        resetBtn = findViewById(R.id.resetBtn)
        rnd = Random()
    }
}