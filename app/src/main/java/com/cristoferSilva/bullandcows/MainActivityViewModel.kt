package com.cristoferSilva.bullandcows

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {
    private var inputGuess: String = "";
    private var randomNumber: String = " ";

    fun sendGuess(): Boolean {
        if(inputGuess.equals(randomNumber))
            return true;
        return false
    }

    fun setInputGuess(guess: String) {
        inputGuess = guess;
    }

    fun getInputGuess(): String = inputGuess

    fun createRandomNumber() {
        var number: Int;
        do {
            number = Random.nextInt(1000, 9999);
            val stringOfTheNumeber = number.toString();
        } while (!areNumbersDifferent(stringOfTheNumeber))
        randomNumber = number.toString();
    }

    private fun areNumbersDifferent(stringNumber: String): Boolean {
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
}