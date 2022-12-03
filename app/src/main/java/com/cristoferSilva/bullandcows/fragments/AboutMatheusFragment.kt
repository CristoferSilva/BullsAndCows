package com.cristoferSilva.bullandcows.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cristoferSilva.bullandcows.MainActivity
import com.cristoferSilva.bullandcows.R

class AboutMatheusFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val aboutFragment = inflater.inflate(R.layout.fragment_about_matheus, container, false)
        // Inflate the layout for this fragment
        val buttonLinkedin = aboutFragment.findViewById<View>(R.id.btn_linkedin_matheus)

        buttonLinkedin.setOnClickListener(){
            startActivity( Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/matheus-coelho005/")))
        }
        return aboutFragment;
    }
}