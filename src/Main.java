import jdk.nashorn.internal.runtime.Debug;

/**
 *
 * Project Name: Ray2048j
 * Project Description: Java Implementation of the course project of ENGG1110
 *
 */

public class Main {

    public static void main(String[] args) {
        MainSystem ms = new MainSystem();
        ms.setMode();

        if (ms.getMode() == 0) {
            // Normal Mode
            ms.readSeed();
        }
        else
        {
            // Debug Mode
            ms.enableDebugMode();
        }

        while (!ms.isGameEnd()) {
            if (ms.getMode() == 0) {
                // Game Render
                ms.getGameBoard().generateNewCell();
                ms.printBoard();
            } else {
                // Debug Mode
                ms.printBoard();
                ms.debug().insertCell();
            }

            // Game Over
            if (ms.isGameOver()) {
                ms.setGameOver();
            }

            // Main Game Logic
            ms.readCommand();

            // The player won the game
            if (ms.playerWon()) {
                ms.setGameOver();
            }
        }
    }

}
