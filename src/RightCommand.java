/**
 * Created by ray on 3/1/2016.
 */
public class RightCommand extends Command {
    public RightCommand(GameBoard gameBoard) {
        super(gameBoard);
    }

    @Override
    protected boolean pull() {
        boolean actionTaken = false;
        int[][] board = this.gameBoard.getBoard();

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                for (int k = 3 - j; k > 0; k--)
                {
                    if (board[i][k - 1] != 0 && board[i][k] == 0)
                    {
                        board[i][k] = board[i][k - 1];
                        board[i][k - 1] = 0;
                        actionTaken = true;
                    }
                }
            }
        }

        return actionTaken;
    }

    @Override
    protected boolean combine() {
        boolean actionTaken = false;
        int[][] board = this.gameBoard.getBoard();

        for (int i = 0; i < 4; i++)
        {
            for (int j = 3; j > 0; j--)
            {
                if (board[i][j] == board[i][j - 1] && board[i][j] != 0)
                {
                    board[i][j] *= 2;
                    board[i][j-1] = 0;
                    actionTaken = true;
                }
            }
        }

        return actionTaken;
    }
}
