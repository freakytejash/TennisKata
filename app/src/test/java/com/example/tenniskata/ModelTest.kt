package com.example.tenniskata

import com.example.tenniskata.model.Model
import com.example.tenniskata.util.Score
import org.junit.Assert
import org.junit.Test

class ModelTest {
    private val model = Model()

    @Test
    fun `player1 and player2 should return default score as love`() {
        Assert.assertEquals(model.player1score, Score.Love)
        Assert.assertEquals(model.player2score, Score.Love)
    }

    @Test
    fun `player1 should increment player1 value to fifteen and player2 value should remain the same`() {
        val score = model.player1()

        Assert.assertEquals(score.first, Score.Fifteen)
        Assert.assertEquals(score.second, Score.Love)
    }

    @Test
    fun `player2 should increment player2 value to fifteen and player1 value should remain the same`() {
        val score = model.player2()

        Assert.assertEquals(score.second, Score.Fifteen)
        Assert.assertEquals(score.first, Score.Love)
    }

    @Test
    fun `player1 values should increment correctly`() {
        var score = model.player1()
        Assert.assertEquals(score.first, Score.Fifteen)
        score = model.player1()
        Assert.assertEquals(score.first, Score.Thirty)
        score = model.player1()
        Assert.assertEquals(score.first, Score.Forty)
        score = model.player1()
        Assert.assertEquals(score.first, Score.Winner)
    }

    @Test
    fun `player2 values should increment correctly`() {
        var score = model.player2()
        Assert.assertEquals(score.second, Score.Fifteen)
        score = model.player2()
        Assert.assertEquals(score.second, Score.Thirty)
        score = model.player2()
        Assert.assertEquals(score.second, Score.Forty)
        score = model.player2()
        Assert.assertEquals(score.second, Score.Winner)
    }

    @Test
    fun `player1 and player2 should be deuce when both player score is forty`() {
        model.player1score = Score.Forty
        model.player2score = Score.Thirty
        val score = model.player2()

        Assert.assertEquals(score.first, Score.Deuce)
        Assert.assertEquals(score.second, Score.Deuce)
    }
}
