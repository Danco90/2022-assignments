package com.daniele.project.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TennisGameTest
{
    TennisGame tg = new TennisGame("Matteo", "Daniele");
    
    @Test
    @DisplayName("Love, All")
    public void test_whenNewGame_thenReturnLoveAll()
    {

        Assertions.assertEquals("Love all", tg.getScore());
    }

    @Test
    @DisplayName("Test Player One wins first ball 'Fifteen,Love'")
    public void testPlayerOneWinsFirstBall()
    {
        createScore(1, 0);
        Assertions.assertEquals("Fifteen,Love", tg.getScore());
    }

    @Test
    @DisplayName("Test 'Fifteen all'")
    public void testFifteenAll()
    {
        tg.playerOneScores();
        tg.playerTwoScores();
        Assertions.assertEquals("Fifteen all", tg.getScore());
    }

    @Test
    @DisplayName("Test Player Two wins first ball")
    public void testPlayerTwoWinsFirstBall()
    {   createScore(0,2);
        Assertions.assertEquals("Love,Thirty", tg.getScore());
    }



    @Test
    @DisplayName("Test Player One wins first three balls")
    public void testPlayerOneWinsFirstThreeBalls()
    {
        createScore(3,0);
        Assertions.assertEquals("Forty,Love", tg.getScore());
    }

    @Test
    @DisplayName("Test Players are Deuce")
    public void testPlayersAreDeuce()
    {
        createScore(3,3);
        Assertions.assertEquals("Deuce", tg.getScore());
    }


    @Test
    @DisplayName("Test Player One wins the game")
    public void testPlayerOneWinsGame()
    {
        createScore(4,0);
        Assertions.assertEquals("Matteo wins", tg.getScore());
    }

    @Test
    @DisplayName("Test Player Two wins the game")
    public void testPlayerTwoWinsGame()
    {
        createScore(1,4);
        Assertions.assertEquals("Daniele wins", tg.getScore());
    }

    @Test
    @DisplayName("Test Players are Deuce 4-4")
    public void testPlayersAreDeuce4()
    {
        createScore(4,4);
        Assertions.assertEquals("Deuce", tg.getScore());
    }

    @Test
    @DisplayName("Test Player Two in Advantage")
    public void testPlayerTwoAdvantage()
    {
        createScore(4,5);
        Assertions.assertEquals("Advantage Daniele", tg.getScore());
    }

    @Test
    @DisplayName("Test Player One in Advantage")
    public void testPlayerOneAdvantage()
    {
        createScore(5,4);
        Assertions.assertEquals("Advantage Matteo", tg.getScore());
    }

    @Test
    @DisplayName("Test Player Two wins 2-4")
    public void testPlayerTwoWins()
    {
        createScore(1,4);
        Assertions.assertEquals("Daniele wins", tg.getScore());
    }

    @Test
    @DisplayName("Test Player Two wins after Advantage")
    public void testPlayerTwoWinsAfterAdvantage()
    {
        createScore(6,8);
        Assertions.assertEquals("Daniele wins", tg.getScore());
    }

    @Test
    @DisplayName("Test Player One wins after Advantage")
    public void testPlayerOneWinsAfterAdvantage()
    {
        createScore(8,6);
        Assertions.assertEquals("Matteo wins", tg.getScore());
    }

    private void createScore(int playerOneBalls, int playerTwoBalls)
    {
        for(int i=0; i<playerOneBalls; i++)
            tg.playerOneScores();

        for(int i=0; i<playerTwoBalls; i++)
            tg.playerTwoScores();
    }
}
