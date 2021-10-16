package com.example.kockadobas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var kocka1img: ImageButton
    private lateinit var kocka2img: ImageButton
    private lateinit var scoreDisplay: TextView
    private lateinit var kocka1btn: Button
    private lateinit var kocka2btn: Button
    private lateinit var throwBtn: Button
    private lateinit var resetBtn: Button
    private lateinit var gameBtn: Button
    private lateinit var rnd: Random
    private lateinit var resetAlert: AlertDialog.Builder
    private lateinit var newGameAlert: AlertDialog.Builder
    private lateinit var gameComplete: AlertDialog.Builder
    private var numOfKocka = 2
    private var kocka1val = 0
    private var kocka2val = 0
    private var enemyVal = 0

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
            diceThrow()
            if (numOfKocka == 2) {
                val sum = kocka1val + kocka2val
                scoreDisplay.append("($kocka1val + $kocka2val) $sum \n")
            } else {
                scoreDisplay.append("$kocka1val \n")
            }
        }

        resetBtn.setOnClickListener {
            val dialog = resetAlert.create()
            dialog.show()
        }

        gameBtn.setOnClickListener {
            val dialog = newGameAlert.create()
            dialog.show()

            throwBtn.setOnClickListener {
                diceThrow()
                scoreDisplay.append("Ellenfel: $enemyVal \n")
                val sum = kocka1val + kocka2val
                scoreDisplay.append("Jatekos elso: ($kocka1val + $kocka2val) $sum \n")
                game()
            }
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
        gameBtn = findViewById(R.id.gameBtn)
        rnd = Random()
        resetAlert = AlertDialog.Builder(this@MainActivity)
        resetAlert
            .setTitle("Reset")
            .setMessage("Biztosan torli az eddigi dobasokat?")
            .setPositiveButton("igen") {_, _ -> reset()}
            .setNegativeButton("nem") {_, _ ->}
        newGameAlert = AlertDialog.Builder(this@MainActivity)
            .setTitle("Uj Jatek")
            .setMessage("Szeretne uj jatekot kezdeni? Jatszani csak 2 kockaval lehet")
            .setPositiveButton("igen") {_, _ -> newGame()}
            .setNegativeButton("nem") {_, _ -> reset()}
        gameComplete = AlertDialog.Builder(this)
            .setMessage("Szeretnel ujra jatszani?")
            .setPositiveButton("igen") {_, _ -> newGame()}
            .setNegativeButton("nem") {_, _ -> reset()}
    }

    private fun diceThrow() {
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
        }
    }

    private fun dice1Throw() {
        kocka1val = rnd.nextInt(6)+1
        when(kocka1val) {
            1 -> kocka1img.setImageResource(R.drawable.kocka1)
            2 -> kocka1img.setImageResource(R.drawable.kocka2)
            3 -> kocka1img.setImageResource(R.drawable.kocka3)
            4 -> kocka1img.setImageResource(R.drawable.kocka4)
            5 -> kocka1img.setImageResource(R.drawable.kocka5)
            6 -> kocka1img.setImageResource(R.drawable.kocka6)
        }
    }

    private fun dice2Throw() {
        kocka2val = rnd.nextInt(6)+1
        when(kocka2val) {
            1 -> kocka2img.setImageResource(R.drawable.kocka1)
            2 -> kocka2img.setImageResource(R.drawable.kocka2)
            3 -> kocka2img.setImageResource(R.drawable.kocka3)
            4 -> kocka2img.setImageResource(R.drawable.kocka4)
            5 -> kocka2img.setImageResource(R.drawable.kocka5)
            6 -> kocka2img.setImageResource(R.drawable.kocka6)
        }
    }

    private fun reset() {
        scoreDisplay.text = ""
        kocka2img.visibility = View.VISIBLE
        kocka1img.setImageResource(R.drawable.kocka1)
        kocka2img.setImageResource(R.drawable.kocka1)

        throwBtn.setOnClickListener {
            diceThrow()
            if (numOfKocka == 2) {
                val sum = kocka1val + kocka2val
                scoreDisplay.append("($kocka1val + $kocka2val) $sum \n")
            } else {
                scoreDisplay.append("$kocka1val \n")
            }
        }
    }

    private fun newGame() {
        scoreDisplay.text = ""
        numOfKocka = 2
        kocka1img.setImageResource(R.drawable.kocka1)
        kocka2img.setImageResource(R.drawable.kocka1)
        kocka2img.visibility = View.VISIBLE
        Toast.makeText(this@MainActivity, "Dobj", Toast.LENGTH_SHORT).show()
        enemyVal = (rnd.nextInt(6)+1) + (rnd.nextInt(6)+1)
    }

    private fun game() {
        Toast.makeText(this, "Valassz kockat amit ujra szeretnel dobni", Toast.LENGTH_LONG).show()
        kocka1img.setOnClickListener {
            dice1Throw()
            val sum = kocka1val + kocka2val
            scoreDisplay.append("Jatekos masodik: ($kocka1val + $kocka2val) $sum \n")
            game2()
        }
        kocka2img.setOnClickListener {
            dice2Throw()
            val sum = kocka1val + kocka2val
            scoreDisplay.append("Jatekos masodik: ($kocka1val + $kocka2val) $sum \n")
            game2()
        }
    }

    private fun game2() {
        val playerVal = kocka1val + kocka2val
        if (enemyVal > playerVal) {
            val dialog = gameComplete.create()
            dialog.setTitle("Vesztettel")
            dialog.show()
        }
        else if (enemyVal == playerVal) {
            val dialog = gameComplete.create()
            dialog.setTitle("Dontetlen")
            dialog.show()
        }
        else {
            val dialog = gameComplete.create()
            dialog.setTitle("Nyertel")
            dialog.show()
        }
    }
}