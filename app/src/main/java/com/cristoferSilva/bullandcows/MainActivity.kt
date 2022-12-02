package com.cristoferSilva.bullandcows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristoferSilva.bullandcows.adapter.AdapterScore
import com.cristoferSilva.bullandcows.databinding.ActivityMainBinding
import com.cristoferSilva.bullandcows.model.Score

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var viewModel: MainActivityViewModel;
    private lateinit var scoreAdapter: AdapterScore
    private val scoreList: MutableList<Score> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        viewModel = MainActivityViewModel();
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        scoreAdapter = AdapterScore(this, scoreList)
        val recycleViewScores = binding.recycleViewScores
        recycleViewScores.layoutManager = LinearLayoutManager(this)
        recycleViewScores.setHasFixedSize(true)
        recycleViewScores.adapter = scoreAdapter

        binding.nickName.text = viewModel.getInputPersonName()

        binding.inputGueesBlock.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                viewModel.setInputGuess(s.toString());
            }
        });
        viewModel.createRandomNumber();
        binding.guessButton.setOnClickListener(){
            executeGuess()
        }
    }

    private fun executeGuess() {
        binding.textView5.text = viewModel.getRandomNumber().toString()
        if (viewModel.getInputGuess().length < 4) {
            Toast.makeText(
                this,
                "he number must be more than 4 digits!", Toast.LENGTH_LONG
            ).show()
        } else if (!viewModel.areNumbersDifferent(viewModel.getInputGuess())) {
            Toast.makeText(
                this,
                "Put number with different digits!", Toast.LENGTH_LONG
            ).show()
        } else {
            var isCorrect = viewModel.sendGuess(this.scoreList);
            if (isCorrect) {
                binding.guessButton.visibility = View.INVISIBLE
                binding.congratTextView.visibility = View.VISIBLE
            }
            scoreAdapter.notifyDataSetChanged()
        }
    }

    private fun  itemsDelista(){
        val score1 = Score(1,1,1234)
        scoreList.add(score1)

        val score2 = Score(1,1,1234)
        scoreList.add(score2)

        val score3 = Score(1,1,1234)
        scoreList.add(score3)

        val score4 = Score(1,1,1234)
        scoreList.add(score4)

        val score5 = Score(1,1,1234)
        scoreList.add(score5)

        val score6 = Score(1,1,1234)
        scoreList.add(score6)
    }

}