package com.example.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_number_guess.*
import java.util.Random

class NumberGuessActivity : AppCompatActivity() {
    var count = 0
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)

        val start = findViewById<Button>(R.id.start)
        val proof = findViewById<Button>(R.id.proof)
        proof.isEnabled = false

    }

    fun randomNum(v: View) : Int{
        val numberIn = findViewById<EditText>(R.id.numberIn)
        numberIn.setText("")
        val random = Random()
        num = random.nextInt(1001)
        Toast.makeText(this, "$num", Toast.LENGTH_LONG).show()
        proof.isEnabled = true
        return num
    }

    fun shot(v: View){
        // Taps button
        count++

        // take the number put in EditText
        val shot: Int? = numberIn.text.toString().toInt()

        if(shot!! == null){
            Toast.makeText(this, "You have to type a number", Toast.LENGTH_LONG).show()
        }
        if(shot!! < num) {
            Toast.makeText(this, "Higher", Toast.LENGTH_LONG).show()
        }
        if(shot!! > num){
            Toast.makeText(this, "Smaller", Toast.LENGTH_LONG).show()
        }
        if(shot == num){
            Toast.makeText(this, "You win, tap to start button to start again!", Toast.LENGTH_LONG).show()
            proof.isEnabled = false
            val tries = findViewById<TextView>(R.id.tries)
            tries.text = "Your tries $count"
        }
    }
}