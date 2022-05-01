package com.akhil.FRQs.Wk2;

public class GameSpinner {
    private int numSectors;
    private int runLength;
    private int prev;

    public GameSpinner(int numSectors) {
        this.numSectors = numSectors;
        this.runLength = 0;
    }

    public int spin() {
        int val = (int) (Math.random() * numSectors) + 1;
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
}
