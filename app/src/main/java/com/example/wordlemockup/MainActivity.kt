package com.example.wordlemockup

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wordlemockupactually.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Actual values
        var wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        val guessInput = findViewById<EditText>(R.id.userInput)
        val submit = findViewById<Button>(R.id.submit)
        //var response = guessInput.text.toString()
        val warning = makeText(this, "Answer is invalid!", Toast.LENGTH_SHORT)
        val restart = findViewById<Button>(R.id.restart)
        var strikes = 0

        //TextViews: Guesses
        val guessOne = findViewById<TextView>(R.id.guessOne)
        val guessTwo = findViewById<TextView>(R.id.guessTwo)
        val guessThree = findViewById<TextView>(R.id.guessThree)

        //TextViews: Correctness
        val corOne = findViewById<TextView>(R.id.correctnessOne)
        val corTwo = findViewById<TextView>(R.id.correctnessTwo)
        val corThree = findViewById<TextView>(R.id.correctnessThree)
        val results = findViewById<TextView>(R.id.youWon)

        //wordToGuess TextView
        val target = findViewById<TextView>(R.id.correctWord)
        target.text = wordToGuess


        /**
         * Parameters / Fields:
         *   wordToGuess : String - the target word the user is trying to guess
         *   guess : String - what the user entered as their guess
         *
         * Returns a String of 'O', '+', and 'X', where:
         *   'O' represents the right letter in the right place
         *   '+' represents the right letter in the wrong place
         *   'X' represents a letter not in the target word
         */

        //Functions Station!
        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }

        fun youWin(){
            submit.isClickable = false
            target.visibility = View.VISIBLE
            guessInput.isActivated = false
            results.text = "you won!!"
            results.setTextColor(Color.parseColor("#0b8413"))
            results.visibility = View.VISIBLE
            restart.visibility = View.VISIBLE

        }

        fun playTheGame(){
            if (strikes == 0 && guessInput.text.toString().length == 4)
            {
                guessOne.text = "Guess One: " + guessInput.text.toString()
                guessOne.visibility = View.VISIBLE

                corOne.text = "Accuracy: " + checkGuess(guessInput.text.toString().uppercase())
                corOne.visibility = View.VISIBLE

                strikes++

                if(checkGuess(guessInput.text.toString().uppercase()).equals("OOOO"))
                {
                    youWin()
                }

            }
            else if (strikes == 1 && guessInput.text.toString().length == 4)
            {
                guessTwo.text = "Guess Two: " + guessInput.text.toString()
                guessTwo.visibility = View.VISIBLE

                corTwo.text = "Accuracy: " + checkGuess(guessInput.text.toString().uppercase())
                corTwo.visibility = View.VISIBLE

                strikes++

                if(checkGuess(guessInput.text.toString().uppercase()).equals("OOOO"))
                {
                    youWin()
                }
            }
            else if (strikes == 2 && guessInput.text.toString().length == 4)
            {
                guessThree.text = "Guess Three: " + guessInput.text.toString()
                guessThree.visibility = View.VISIBLE

                corThree.text = "Accuracy: " + checkGuess(guessInput.text.toString().uppercase())
                corThree.visibility = View.VISIBLE


                if(checkGuess(guessInput.text.toString().uppercase()).equals("OOOO"))
                {
                    youWin()

                }
                else
                {
                    submit.setBackgroundColor(Color.parseColor("#5e5e5e"))
                    submit.isClickable = false
                    target.visibility = View.VISIBLE
                    guessInput.isActivated = false
                    results.text = "you lost!! try again??"
                    results.setTextColor(Color.parseColor("#84170b"))
                    results.visibility = View.VISIBLE
                    restart.visibility = View.VISIBLE
                }
            }
            else
            {
                warning.show()
            }

        }



        //Operations!
        submit.setOnClickListener(){

            playTheGame()

            restart.setOnClickListener(){
                guessOne.visibility = View.INVISIBLE
                guessTwo.visibility = View.INVISIBLE
                guessThree.visibility = View.INVISIBLE
                corOne.visibility = View.INVISIBLE
                corTwo.visibility = View.INVISIBLE
                corThree.visibility = View.INVISIBLE
                target.visibility = View.INVISIBLE
                results.visibility = View.INVISIBLE
                restart.visibility = View.INVISIBLE

                strikes = 0
                wordToGuess = FourLetterWordList.getRandomFourLetterWord()
                target.text = wordToGuess
                submit.isClickable = true
                submit.setBackgroundColor(Color.parseColor("#E7B1DB"))

            }

        }


    }


}