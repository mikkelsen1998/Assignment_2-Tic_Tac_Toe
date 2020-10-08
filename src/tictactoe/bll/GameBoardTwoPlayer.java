package tictactoe.bll;

import java.util.Random;
//spil
/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {
    private int playerId; //Keeps track of whose turn it is
    private final int boardSize = 3; //Define the array size
    private final int nullVal = -1; //Checks if game is a draw or win
    private int winnerId; //Keeps track of what player wins
    private final int[][] gameBoard = new int[boardSize][boardSize]; //2D array to keep track of players input

    public GameBoardTwoPlayer()
    {
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                gameBoard[i][j] = nullVal;
            }
        }
    }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer()
    {
        return playerId;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is successful the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */
    @Override
    public boolean play(int col, int row)
    {
        if (gameBoard[col][row] != -1)
        {
            return false;
        } else {
            gameBoard[col][row] = playerId;
        }
        if (playerId == 0)
        {
            playerId = 1;
        } else {
            playerId = 0;
        }
        return true;
    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    @Override
    public boolean isGameOver()
    {
        int chkVal = nullVal;
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[1][1] != chkVal) //Checks for Diagonal win condition
        {
            winnerId = gameBoard[1][1];
            return true;
        }
        if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[1][1] != chkVal) //Checks for Diagonal win condition
        {
            winnerId = gameBoard[1][1];
            return true;
        }
        for (int i = 0; i < boardSize; i++)
        {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != chkVal) //Checks for horizontal win conditions
            {
                winnerId = gameBoard[i][0];
                return true;
            }
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i] && gameBoard[0][i] != chkVal) //Checks for vertical win conditions
            {
                winnerId = gameBoard[0][i];
                return true;
            }
        }
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                if (gameBoard[i][j] == chkVal) //If no win conditions are met, return -1 and draw game
                {
                    winnerId = -1;
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    @Override
    public int getWinner()
    {
        return winnerId;
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame()
    {
        playerId = 0;

        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                gameBoard[i][j] = -1;
            }
        }
    }
}