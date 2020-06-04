package com.example.tenniskata.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.tenniskata.R


internal class Screen2 : Fragment() {

    private lateinit var playerOne:EditText
    private lateinit var playerTwo:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.screen2_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerOne = view.findViewById(R.id.edit_player1)
        playerTwo = view.findViewById(R.id.edit_player2)
        val btnPlay = view.findViewById(R.id.btn_play) as Button
        btnPlay.setOnClickListener {
            val action = Screen2Directions.actionScreen2ToScreen3()
            action.player1 = playerOne.text.toString()
            action.player2 = playerTwo.text.toString()
            if(playerOne.text.toString().isNotEmpty() && playerTwo.text.toString().isNotEmpty())
            Navigation.findNavController(requireActivity(), R.id.main_content).navigate(action)
            else{
                Toast.makeText(requireActivity(),"Please Enter Player Name",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
