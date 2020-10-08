package tictactoe.bll;

/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {
     private int playerId;
     public static boolean [][] board;



    protected GameBoardTwoPlayer() {
        //lav et board som er 3x3
        //lav for loop med x og med y koordinaterne
        board= new boolean[3][3];
        for (int x = 0;x<3;x++){
            for (int y = 0; y<3;y++){
                board[x][y]=false;
            }


        }
    }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer() {
        //TODO Implement this method

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
        //TODO Implement this method
        if (playerId == 0){playerId =1;}
        else {playerId =0;}
        //hvis board feltet ikke er optaget. spil og gør optaget
        if (board[col][row]==false){
            board[col][row]=true;
            return true;
        }
        else{return false;}


    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */
    @Override

    public boolean isGameOver() {

        //TODO Implement this method
        //ser om der alle pladser er taget
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y){
            if (board[x][y] == false) {
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
    public int getWinner() {

        //TODO Implement this method


        return playerId;

    }


    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {
        //TODO Implement this method
    }

}