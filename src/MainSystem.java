import java.util.Random;
import java.util.Scanner;

/**
 * Created by ray on 30/12/2015.
 */
public class MainSystem {
    private int mode;
    private Scanner reader;
    private Random generator;

    public MainSystem() {
        this.reader = new Scanner(System.in);
    }

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

    public int getMode()
    {
        return this.mode;
    }

    /**
     * Still have duplication problem.
     * Leave it solved soon.
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

        this.generator = new Random(seed);
    }
}
