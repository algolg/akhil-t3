package com.akhil.FRQs.Wk1;

import java.util.Scanner;

public class HiddenWord {
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    private String word;

    public HiddenWord(String word) {
        this.word = word;
    }

    public String getHint(String guess) {
        String output = "";
        
        for (int i=0; i < guess.length(); i++) {
            boolean added = false;
            if (guess.charAt(i) == this.word.charAt(i)) {
                output += GREEN + String.valueOf(guess.charAt(i)) + RESET; //review how to compare chars
                added = true;
            }
            if (!added) {
                for (int j=0; j < guess.length(); j++) {
                    if (guess.charAt(i) == this.word.charAt(j)) {
                        output += YELLOW + "+" + RESET;
                        added = true;
                        break;
                    }
                }
            }
            if (!added)
                output += "*";
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Input a word: ");
        String word = a.nextLine();
        String highlighted_word = "";
        for (char ch : word.toCharArray()) {
            highlighted_word += HiddenWord.GREEN + ch + HiddenWord.RESET;
        }

        HiddenWord game = new HiddenWord(word);
        System.out.println("\nBegin guessing");
        String guess;
        int num = 1;
        do {
            Scanner b = new Scanner(System.in);
            System.out.print(num + " ");
            guess = b.nextLine();
            System.out.println("  " + (guess = game.getHint(guess)) + "\n");
            num++;
        } while (!guess.equals(highlighted_word));
        System.out.println("Splendid");
    }
}
