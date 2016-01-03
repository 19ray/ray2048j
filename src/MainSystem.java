import java.util.Random;
import java.util.Scanner;

/**
 * Created by ray on 30/12/2015.
 */
public class MainSystem {
    private int mode;
    private boolean IsGameEnd = false;

    private Scanner reader;

    private GameBoard gameBoard;
    private DebugMode debugMode;

    /**
     * Instantiate a new MainSystem instance
     */
    public MainSystem() {
        this.reader = new Scanner(System.in);
        this.gameBoard = new GameBoard();
    }

    /**
     * Set the game mode
     */
    public void setMode()
    {
        int mode;

        while (true) {
            System.out.println("Mode [ Normal Mode (0) |  Debug Mode (1) ]?");

            mode = this.reader.nextInt();

            if (mode == 0 || mode == 1)
                break;
            else
                System.out.println("[Error] Mode is between 0 and 1.");
        }

        this.mode = mode;
    }

    /**
     * Get the current game mode
     * @return int
     */
    public int getMode()
    {
        return this.mode;
    }

    /**
     * Enable the Debug Mode
     */
    public void enableDebugMode() {
        this.debugMode = new DebugMode(this);
    }

    /**
     * Perform debugging by accessing the functionality defined in the Debug Mode class
     * @return DebugMode
     */
    public DebugMode debug() {
        return debugMode;
    }

    /**
     * Check whether the game ends
     * @return boolean
     */
    public boolean isGameEnd() {
        return IsGameEnd;
    }

    /**
     * Check whether further actions can be taken
     * @return boolean
     */
    public boolean isGameOver() {
        boolean containsZero = false;
        int[][] board = this.getGameBoard().getBoard();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!containsZero && board[i][j] == 0)
                    containsZero = true;
            }
        }

        if (!containsZero) {
            // When there is no empty box
            // check if further actions can be taken
            // If merging cannot be performed, it means game over

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    // Can Perform Left / Right Merge ?
                    if (j < 3 && board[i][j] == board[i][j+1]) {
                        return false;
                    }

                    // Can Perform Up / Down Merge ?
                    if (i < 3 && board[i][j] == board[i+1][j]) {
                        return false;
                    }
                }
            }

            return true;
        }

        return false;
    }

    /**
     * Read the random seed
     */
    public void readSeed()
    {
        int seed;

        while (true)
        {
            System.out.println("Random Seed?");

            seed = this.reader.nextInt();

            if (seed < 0 || seed > 32767)
                System.out.println("[Error] Seed is between 0 and 32767");
            else
                break;
        }

        this.gameBoard.setGenerator(seed);
    }

    /**
     * Read and try to execute the command
     */
    public void readCommand()
    {
        int cmd;

        while (true) {
            cmd = getCommand();

            if (this.hasExecuted(cmd))
                break;
            else
                System.out.println("[Error] invalid direction");
        }
    }

    /**
     * Check whether the game board has been modified after executing a command
     * @param int cmd
     * @return boolean
     */
    private boolean hasExecuted(int cmd) {
        boolean actionTaken = false;

        switch (cmd) {
            case 1:
                actionTaken = (new LeftCommand(this.getGameBoard())).execute();
                break;
            case 2:
                actionTaken = (new RightCommand(this.getGameBoard())).execute();
                break;
            case 3:
                actionTaken = (new UpCommand(this.getGameBoard())).execute();
                break;
            case 4:
                actionTaken = (new DownCommand(this.getGameBoard())).execute();
                break;
            case 5:
                exitGame();
                break;
        }

        return actionTaken;
    }

    /**
     * Get the command inputted by the player
     * @return int
     */
    private int getCommand() {
        int cmd;

        while (true) {
            System.out.println("Command: [ LEFT (1) | RIGHT (2) | UP (3) | DOWN (4) | QUIT (5) ]?");

            cmd = this.reader.nextInt();

            if (cmd < 1 || cmd > 5)
                System.out.println("[Error] Command is between 1 and 5");
            else
                break;
        }

        return cmd;
    }

    /**
     * Get the GameBoard of the Main System
     * @return GameBoard
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Print the GameBoard
     */
    public void printBoard()
    {
        for (int i = 0; i < 4; i++)
        {
            System.out.println("+----+----+----+----+");

            for (int j = 0; j < 4; j++)
            {
                if (this.gameBoard.getBoard()[i][j] == 0)
                    System.out.print("|    ");
                else
                    System.out.printf("|%4d", this.gameBoard.getBoard()[i][j]);
            }

            System.out.println("|");
        }

        System.out.println("+----+----+----+----+");
    }

    /**
     * Check whether the game board contains a 2048 cell
     * @return boolean
     */
    public boolean playerWon()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (this.getGameBoard().getBoard()[i][j] == 2048)
                    return true; // 2048 WIN
            }
        }

        return false;
    }

    /**
     * Exit the game
     */
    public void exitGame()
    {
        System.out.println("Bye :(");
        System.exit(0);
    }

    /**
     * End the game
     */
    public void setGameOver()
    {
        this.printBoard();
        System.out.println("Game Over");
        this.IsGameEnd = true;
        System.exit(0);
    }
}
