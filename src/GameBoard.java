/**
 * Created by ray on 26/12/2015.
 */
public class GameBoard {

    private int[][] board;

    public GameBoard() {
        this.initBoard();
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    private void initBoard()
    {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                board[i][j] = 0;
    }
}
