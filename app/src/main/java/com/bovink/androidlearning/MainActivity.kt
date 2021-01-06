package com.bovink.androidlearning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var diceTextView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView_dice)
        textView.text = "Roll the Dice";
        val btn: Button = findViewById(R.id.button_click)
        btn.setOnClickListener { view ->

            println("s")
            println("s")
            rollDice()

            val diceNum = (1..6).random()
            textView.text = diceNum.toString()
            val dice = when (diceNum) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceTextView.setImageResource(dice)
        }

        val count_up: Button = findViewById(R.id.btn_count_up)
        count_up.setOnClickListener { countUp() }
        diceTextView = findViewById(R.id.iv_dice)
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
        diceTextView.setImageResource(dice)

    }

    private fun rollDice() {

        Toast.makeText(this, "button click", Toast.LENGTH_SHORT).show()

    }
}