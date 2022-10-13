package com.daniele.project.tennis;

public class TennisGame
{
    private String playerOneName;
    private String playerTwoName;
    private int playerOneScore;
    private int playerTwoScore;

    public TennisGame(String playerOneName, String playerTwoName)
    {
         this.playerOneName = playerOneName;
         this.playerTwoName = playerTwoName;
    }

    public void playerOneScores() { playerOneScore++; }

    public void playerTwoScores() { playerTwoScore++; }

    public String getScore()
    {   if(hasWinner())
            return playerWithHighestScore() + " wins";
        else if(isDeuce())
            return "Deuce";
        else if(isAdvantage())
            return "Advantage " + playerWithHighestScore();
        else if(playerOneScore == playerTwoScore)
            return convertScore(playerOneScore)+" all";
        else return convertScore(playerOneScore) + "," + convertScore(playerTwoScore);
    }

    private String playerWithHighestScore()
    {    return playerOneScore > playerTwoScore ? playerOneName : playerTwoName; }

    private String convertScore(int playerScore)
    {
        String result = switch(playerScore)
        {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException("Score " +playerScore+ " not supported");
        };
        return result;
    }

    private boolean isDeuce()
    {
         return playerOneScore >=3 && playerOneScore == playerTwoScore;

    }

    private boolean isAdvantage()
    {
        if(playerOneScore >= 3 && playerOneScore == playerTwoScore + 1)
            return true;
        else if (playerTwoScore >= 3 && playerTwoScore >= playerOneScore + 1)
            return true;
        else return false;
    }

    private boolean hasWinner()
    {
        if(playerOneScore > 3 && playerOneScore >= playerTwoScore + 2)
            return true;
        else if(playerTwoScore > 3 && playerTwoScore >= playerOneScore + 2)
            return true;
        else return false;
    }
}
