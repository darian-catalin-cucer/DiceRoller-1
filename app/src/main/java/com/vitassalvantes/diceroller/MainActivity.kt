package com.vitassalvantes.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val normalDice = Dice(6)
        val firstDiceRoll = normalDice.roll()
        val secondDiceRoll = normalDice.roll()

        // Find the ImageView in the layout
        val firstDiceImage: ImageView = findViewById(R.id.firstDiceImage)
        val secondDiceImage: ImageView = findViewById(R.id.secondDiceImage)

        // Update the ImageView with the correct drawable resource ID
        firstDiceImage.setImageResource(
            when (firstDiceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        )

        secondDiceImage.setImageResource(
            when (secondDiceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        )

        // Update the content description
        firstDiceImage.contentDescription = firstDiceRoll.toString()
        secondDiceImage.contentDescription = secondDiceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}