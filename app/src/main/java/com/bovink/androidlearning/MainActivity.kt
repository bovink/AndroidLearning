package com.bovink.androidlearning

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var ivDice1: ImageView
    lateinit var ivDice2: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView_dice)
        textView.text = "Roll the Dice";
        val btn: Button = findViewById(R.id.button_click)
        btn.setOnClickListener { rollDice() }

        val count_up: Button = findViewById(R.id.btn_count_up)
        count_up.setOnClickListener { countUp() }
        ivDice1 = findViewById(R.id.iv_dice)
        ivDice2 = findViewById(R.id.iv_dice2)
    }

    private fun getRandomDiceImage(): Int {
        val num = (1..6).random()

        val image = when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return image
    }

    private fun countUp() {

        var currentText: Int
        try {

            currentText = textView.text.toString().toInt()
            if (currentText != 6) {

                currentText += 1
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            currentText = 1
        }
        println(currentText.toString())
        textView.text = currentText.toString()
        val dice = when (currentText) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        ivDice1.setImageResource(dice)

    }

    private fun rollDice() {

//        Toast.makeText(this, "button click", Toast.LENGTH_SHORT).show()
//        val dice1 = getRandomDiceImage()
//        ivDice1.setImageResource(dice1)
//
//        val dice2 = getRandomDiceImage()
//        ivDice2.setImageResource(dice2)

        startActivity(Intent(this,ShowAlertActivity::class.java));
    }
}