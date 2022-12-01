package com.cristoferSilva.bullandcows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.cristoferSilva.bullandcows.databinding.ActivityInitialViewBinding

class InitialViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInitialViewBinding;
    private lateinit var viewModel: MainActivityViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainActivityViewModel();
        binding = ActivityInitialViewBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.editPersonName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                viewModel.setInputPersonName(s.toString());
            }
        });
        binding.playButton.setOnClickListener(){
            //val navigateToActivityMain = Intent(MainActivity)
            //bindingInitialView.playProgressBar.visibility = setVisible()
        }
    }
}