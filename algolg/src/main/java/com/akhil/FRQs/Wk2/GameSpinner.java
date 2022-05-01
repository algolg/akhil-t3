package com.akhil.FRQs.Wk2;

import java.util.Scanner;

public class GameSpinner {
    private int numSectors;
    private int runLength;
    private int prev;

    public GameSpinner(int numSectors) {
        this.numSectors = numSectors;
        this.runLength = 0;
    }

    public int spin() {
        int val = (int) (Math.random() * numSectors) + 1; // Starts at 1 -> add 1
        if (val == prev) {
            runLength++;
        }
        else {
            runLength = 1;
        }
        prev = val;
        return val;
    }

    public int currentRun() {
        return this.runLength;
    }

    public static void main(String[] args) {
        GameSpinner game = new GameSpinner(4);
        Scanner a = new Scanner(System.in);
        String input;
        boolean done = false;

        System.out.println("Initialized a spinner with 4 sectors");
        System.out.println("Current run: " + game.currentRun());
        while (!done) {
            System.out.println("\nSpun with a result of " + game.spin());
            System.out.println("Current run: " + game.currentRun());
            System.out.print("Press enter to spin. Type 'EXIT' to stop. ");
            input = a.nextLine();
            if (input.equals("EXIT")) {
                done = true;
            }
        }
    }
}
