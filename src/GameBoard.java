import java.util.Random;

/**
 * Created by ray on 26/12/2015.
 */
public class GameBoard {

    private int[][] board;

    private Random generator;

    public GameBoard() {
        this.board = new int[4][4];
        this.initBoard();
    }

    /**
     * Set up the Random number generator by a given seed
     */
    public void setGenerator(long seed) {
        this.generator = new Random(seed);
    }

    /**
     * Get the game board int array matrix
     * @return int[][]
     */
    public int[][] getBoard() {
        return this.board;
    }

    /**
     * Directly set the game board
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * Initiate the board by setting all elements as 0
     */
    private void initBoard()
    {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                this.board[i][j] = 0;
    }

    /**
     * Generate a new random number and insert it into the game board
     */
    public void generateNewCell()
    {
        int row, column;

        while(true) {
            row = this.generator.nextInt(4);
            column = this.generator.nextInt(4);
            if(this.board[row][column] == 0) {
                this.board[row][column] = ((this.generator.nextInt(2)) + 1) * 2;
                break;
            }
        }
    }
}
