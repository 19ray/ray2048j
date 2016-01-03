import java.io.*;
import java.util.Scanner;

/**
 * Created by ray on 3/1/2016.
 */
public class DebugMode {
    MainSystem ms;
    Scanner reader;

    public DebugMode(MainSystem ms) {
        this.ms = ms;
        this.reader = new Scanner(System.in);

        this.readMap();
    }

    /**
     * Insert a new cell (2 or 4) directly to the game board
     */
    public void insertCell() {
        int row, column, newCell;
        int[][] board = this.ms.getGameBoard().getBoard();

        while (true)
        {
            row = this.readRow();
            column = this.readColumn();

            if (board[row][column] == 0)
                break;
            else
                System.out.printf("[Error] (%d, %d) is occupied\n", row, column);
        }

        newCell = this.readNewCell();

        board[row][column] = newCell;
    }

    /**
     * Read the row index from the player
     * @return int
     */
    private int readRow() {
        int row;

        while (true)
        {
            System.out.println("[Debug Mode] Row [0-3]?");

            row = this.reader.nextInt();

            if (row >= 0 && row <= 3)
                break;
            else
                System.out.println("[Error] Row is between 0 and 3");
        }

        return row;
    }

    /**
     * Read the column index from the player
     * @return int
     */
    private int readColumn() {
        int column;

        while (true)
        {
            System.out.println("[Debug Mode] Column [0-3]?");

            column = this.reader.nextInt();

            if (column >= 0 && column <= 3)
                break;
            else
                System.out.println("[Error] Column is between 0 and 3");
        }

        return column;
    }

    /**
     * Read the value of the new cell from the player
     * @return int
     */
    private int readNewCell() {
        int newCell;

        while (true)
        {
            System.out.println("[Debug Mode] Generate 2 or 4?");

            newCell = this.reader.nextInt();

            if (newCell == 2 || newCell == 4)
                break;
            else
                System.out.println("[Error] Cell value is either 2 or 4");
        }

        return newCell;
    }

    /**
     * Read the game board from map.txt
     */
    private void readMap() {
        int[][] board = new int[4][4];

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("map.txt"));
            String fileLine;
            int row = 0;

            while ((fileLine = fileReader.readLine()) != null) {
                for (int i = 0; i < 4; i++) {
                    board[row][i] = Integer.parseInt(fileLine.split(" ")[i]);
                }

                row++;
            }

            ms.getGameBoard().setBoard(board);
        } catch (Exception e) {
            System.out.println("Failed to open map.txt");
            System.out.println("With errors: " + e.getMessage());
            System.exit(0);
        }
    }
}
