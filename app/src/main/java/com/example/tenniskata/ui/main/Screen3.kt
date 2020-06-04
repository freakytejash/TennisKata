package com.example.tenniskata.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.tenniskata.R
import com.example.tenniskata.model.Model
import kotlinx.android.synthetic.main.screen3_fragment.*

internal class Screen3 : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var playerOneName: TextView
    private lateinit var playerTwoName: TextView
    private lateinit var playerOneScore: TextView
    private lateinit var playerTwoScore: TextView
    private lateinit var playerOneBtn: Button
    private lateinit var playerTwoBtn: Button
    private lateinit var endBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.screen3_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, mainViewModelfactory).get(MainViewModel::class.java)
        viewModel.scoreLiveData.observe(this, scoreLiveDataobserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerOneName = view.findViewById(R.id.txt_player1)
        playerTwoName = view.findViewById(R.id.txt_player2)
        playerOneScore = view.findViewById(R.id.txt_score1)
        playerTwoScore = view.findViewById(R.id.txt_score2)
        playerOneBtn = view.findViewById(R.id.btn_player1)
        playerTwoBtn = view.findViewById(R.id.btn_player2)
        endBtn = view.findViewById(R.id.btn_end)
        playerOneBtn.setOnClickListener { viewModel.player1()}
        playerTwoBtn.setOnClickListener { viewModel.player2()}
        Screen3Args.fromBundle(requireArguments()).run {
            playerOneName.text = player1
            playerTwoName.text = player2
        }
        btn_end.setOnClickListener{
            val action = Screen3Directions.actionScreen3ToScreen4()
            action.score1 = playerOneScore.text.toString()
            action.score2 = playerTwoScore.text.toString()
            action.player1 = playerOneName.text.toString()
            action.player2 = playerTwoName.text.toString()
            Navigation.findNavController(requireActivity(), R.id.main_content).navigate(action)
        }
    }

    private val mainViewModelfactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(Model()) as T
        }
    }

    private val scoreLiveDataobserver = Observer<Pair<String, String>> {
        playerOneScore.text = it.first
        playerTwoScore.text = it.second
    }
}
