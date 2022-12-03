package com.cristoferSilva.bullandcows.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.cristoferSilva.bullandcows.R
import kotlinx.android.synthetic.main.fragment_about_cristofer.*

class AboutCristoferFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val aboutFragment = inflater.inflate(R.layout.fragment_about_cristofer, container, false)
        // Inflate the layout for this fragment
        val buttonLinkedin = aboutFragment.findViewById<View>(R.id.btn_linkedin_cristofer)

        buttonLinkedin.setOnClickListener(){
            startActivity( Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/cristofer-silva-099b43215")))
        }
        // Inflate the layout for this fragment
        return aboutFragment
    }
}