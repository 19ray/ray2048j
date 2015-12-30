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
    }

}
