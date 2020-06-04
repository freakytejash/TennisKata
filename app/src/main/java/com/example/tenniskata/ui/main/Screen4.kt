package com.example.tenniskata.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.tenniskata.R

internal class Screen4 : Fragment() {

    private lateinit var playerOne: TextView
    private lateinit var playerTwo: TextView
    private lateinit var playerOneScore: TextView
    private lateinit var playerTwoScore: TextView
    private lateinit var resetBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.screen4_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerOneScore = view.findViewById(R.id.txt_score1)
        playerTwoScore = view.findViewById(R.id.txt_score2)
        playerOne = view.findViewById(R.id.txt_player1)
        playerTwo = view.findViewById(R.id.txt_player2)
        resetBtn = view.findViewById(R.id.btn_reset)
        Screen4Args.fromBundle(requireArguments()).run {
            playerOne.text = player1
            playerTwo.text = player2
            playerOneScore.text = score1
            playerTwoScore.text = score2}
        resetBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.main_content)
                .navigate(R.id.action_screen4_to_screen1)
        }
    }
}
