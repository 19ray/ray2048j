/**
 * Created by ray on 3/1/2016.
 */
public abstract class Command {

    protected GameBoard gameBoard;

    public Command(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * Try to execute the command
     * @return boolean
     */
    protected final boolean execute() {
        boolean step1 = this.pull();
        boolean step2 = this.combine();
        boolean step3 = this.pull();

        return step1 || step2;
    }

    /**
     * A command must implement a pull method
     * @return boolean
     */
    protected abstract boolean pull();

    /**
     * A command must implement a combine method
     * @return boolean
     */
    protected abstract boolean combine();

}
