package com.akhil.FRQs.Wk1;

import java.util.Scanner;

public class Range implements NumberGroup {
    int min;
    int max;
    
    @Override
    public boolean contains(int num) {
        if (num >= min && num <= max) {
            return true;
        }
        else {
            return false;
        }
    }

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static void main(String[] args) {
        int min, max, test;
        Scanner a = new Scanner(System.in);
        boolean done, exists;
        String input;

        System.out.println("What is the range's min value? ");
        min = a.nextInt();
        System.out.println("What is the range's max value?" );
        max = a.nextInt();
        NumberGroup range = new Range(min, max);

        System.out.println("Test values. Type '9999' to exit.");
        done = false;
        while (!done) {
            System.out.print("Value: ");
            test = a.nextInt();
            if (test == 9999) {
                break;
            }
            exists = range.contains(test);
            System.out.println(test + " does " + (exists?"":"not ") + "exist within the range");
        }
    }
}
