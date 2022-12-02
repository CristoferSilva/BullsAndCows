package com.cristoferSilva.bullandcows

import androidx.lifecycle.ViewModel
import com.cristoferSilva.bullandcows.model.Score
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {
    private var inputGuess: String = "";
    private var randomNumber: String = " ";
    companion object{
        private var inputPersonName: String = " ";
    }

    fun sendGuess(scoreList: MutableList<Score>): Boolean {
        var score = Score()
        score.bullsNumber = 0
        score.cowsNumber = 0
        var bull = 0
        var cows = 0

        for (i in 0 until 4) {
            for (j in 0 until 4) {
                if (i === j && inputGuess[i] === randomNumber[j]) {
                    bull++
                    score.bullsNumber = bull
                }
                if (i !== j && inputGuess[i] === randomNumber[j]) {
                    cows++
                    score.cowsNumber = cows
                }
            }
        }
        score.guessNumber = inputGuess.toInt()

        scoreList.add(score)

        if(inputGuess.equals(randomNumber))
            return true;
        return false
    }

    fun setInputGuess(guess: String) {
        inputGuess = guess;
    }

    fun setInputPersonName(personName: String){
        inputPersonName = personName;
    }

    fun getInputPersonName() : String = inputPersonName

    fun getInputGuess(): String = inputGuess

    fun createRandomNumber() {
        var number: Int;
        do {
            number = Random.nextInt(1000, 9999);
            val stringOfTheNumeber = number.toString();
        } while (!areNumbersDifferent(stringOfTheNumeber))
        randomNumber = number.toString();
    }

    public fun areNumbersDifferent(stringNumber: String): Boolean {
        var i = 0;
        var j = 0;

       var numbersArray = mutableListOf<Int>();

       if (stringNumber.length > 0){
           stringNumber.split("").forEach { a ->
               if (!a.equals(""))
                    numbersArray.add(a.toInt());
            };
        }

        while (i < numbersArray.size) {
            j = i + 1;
           while (j < numbersArray.size) {
              if (numbersArray[i].equals(numbersArray[j]))
                   return false;

               j++;
           }
           i++;
       }
        return true;
    }

    fun getRandomNumber(): Int {
        return randomNumber.toInt()
    }
}