package com.cristoferSilva.bullandcows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import com.cristoferSilva.bullandcows.databinding.ActivityInitialViewBinding

import com.cristoferSilva.bullandcows.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var bindingInitialView: ActivityInitialViewBinding;
    private lateinit var viewModel: MainActivityViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        viewModel = MainActivityViewModel();

        bindingInitialView = ActivityInitialViewBinding.inflate(layoutInflater);
        setContentView(bindingInitialView.root);

        bindingInitialView.editPersonName.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                viewModel.setInputPersonName(s.toString());
            }
        });
        bindingInitialView.playButton.setOnClickListener(){
            //bindingInitialView.playProgressBar.visibility = setVisible()
        }


        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

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
        binding.guessButton.setOnClickListener(){
            viewModel.sendGuess();
        }
        viewModel.createRandomNumber();
    }
}