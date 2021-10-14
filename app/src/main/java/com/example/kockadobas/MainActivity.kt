package com.example.kockadobas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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
    private lateinit var resetAlert: AlertDialog.Builder
    private var numOfKocka = 2
    private var kocka1val = 0
    private var kocka2val = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        kocka1btn.setOnClickListener {
            kocka2img.visibility = View.GONE
            kocka1img.setImageResource(R.drawable.kocka1)
            numOfKocka = 1
        }

        kocka2btn.setOnClickListener {
            kocka2img.visibility = View.VISIBLE
            kocka2img.setImageResource(R.drawable.kocka1)
            numOfKocka = 2
        }

        throwBtn.setOnClickListener {
            if (numOfKocka == 2) {
                kocka1val = rnd.nextInt(6)+1
                kocka2val = rnd.nextInt(6)+1

                when(kocka1val) {
                    1 -> kocka1img.setImageResource(R.drawable.kocka1)
                    2 -> kocka1img.setImageResource(R.drawable.kocka2)
                    3 -> kocka1img.setImageResource(R.drawable.kocka3)
                    4 -> kocka1img.setImageResource(R.drawable.kocka4)
                    5 -> kocka1img.setImageResource(R.drawable.kocka5)
                    6 -> kocka1img.setImageResource(R.drawable.kocka6)
                }

                when(kocka2val) {
                    1 -> kocka2img.setImageResource(R.drawable.kocka1)
                    2 -> kocka2img.setImageResource(R.drawable.kocka2)
                    3 -> kocka2img.setImageResource(R.drawable.kocka3)
                    4 -> kocka2img.setImageResource(R.drawable.kocka4)
                    5 -> kocka2img.setImageResource(R.drawable.kocka5)
                    6 -> kocka2img.setImageResource(R.drawable.kocka6)
                }

                val sum = kocka1val + kocka2val
                scoreDisplay.append("($kocka1val + $kocka2val) $sum \n")
            }
            else {
                kocka1val = rnd.nextInt(6)+1

                when(kocka1val) {
                    1 -> kocka1img.setImageResource(R.drawable.kocka1)
                    2 -> kocka1img.setImageResource(R.drawable.kocka2)
                    3 -> kocka1img.setImageResource(R.drawable.kocka3)
                    4 -> kocka1img.setImageResource(R.drawable.kocka4)
                    5 -> kocka1img.setImageResource(R.drawable.kocka5)
                    6 -> kocka1img.setImageResource(R.drawable.kocka6)
                }

                scoreDisplay.append("$kocka1val \n")
            }
        }

        resetBtn.setOnClickListener {
            val dialog = resetAlert.create()
            dialog.show()
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
        resetAlert = AlertDialog.Builder(this@MainActivity)
        resetAlert
            .setTitle("Reset")
            .setMessage("Biztosan torli az eddigi dobasokat?")
            .setPositiveButton("igen") {_, _ -> reset()}
            .setNegativeButton("nem") {_, _ ->}
    }

    private fun reset() {
        scoreDisplay.text = ""
        kocka2img.visibility = View.VISIBLE
        kocka1img.setImageResource(R.drawable.kocka1)
        kocka2img.setImageResource(R.drawable.kocka1)
    }
}