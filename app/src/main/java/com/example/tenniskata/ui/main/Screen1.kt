package com.example.tenniskata.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import android.widget.Button
import com.example.tenniskata.R

internal class Screen1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.screen1_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnStart = view.findViewById(R.id.btn_start) as Button
        btnStart.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.main_content)
                .navigate(R.id.action_screen1_to_screen2)
        }
    }
}
