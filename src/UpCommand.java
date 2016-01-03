/**
 * Created by ray on 3/1/2016.
 */
public class UpCommand extends Command {
    public UpCommand(GameBoard gameBoard) {
        super(gameBoard);
    }

    @Override
    protected boolean pull() {
        boolean actionTaken = false;
        int[][] board = this.gameBoard.getBoard();

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                for (int k = 0; k < 3 - i; k++)
                {
                    if (board[k + 1][j] != 0 && board[k][j] == 0)
                    {
                        board[k][j] = board[k+1][j];
                        board[k+1][j] = 0;
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

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (board[i+1][j] == board[i][j] && board[i][j] != 0)
                {
                    board[i][j] *= 2;
                    board[i+1][j] = 0;
                    actionTaken = true;
                }
            }
        }

        return actionTaken;
    }
}
