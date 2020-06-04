package com.example.tenniskata.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tenniskata.model.Model

internal class MainViewModel(private val model: Model) : ViewModel() {
    val scoreLiveData = MutableLiveData<Pair<String, String>>()

    init {
        val initialScore = Pair(model.player1score.name, model.player2score.name)
        scoreLiveData.postValue(initialScore)
    }

    fun player1() {
        val score = model.player1()
        val pairOfStrings = Pair(score.first.name, score.second.name)
        scoreLiveData.postValue(pairOfStrings)
    }

    fun player2() {
        val score = model.player2()
        val pairOfStrings = Pair(score.first.name, score.second.name)
        scoreLiveData.postValue(pairOfStrings)
    }
}
