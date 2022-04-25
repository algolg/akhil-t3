package com.akhil.FRQs.Wk1;

import java.util.Scanner;
import java.io.Console;

import com.akhil.Constants;

public class HiddenWord {

    private String word;

    public HiddenWord(String word) {
        this.word = word;
    }

    public String getHint(String guess) {
        String output = "";
        
        for (int i=0; i < guess.length(); i++) {
            boolean added = false;
            if (guess.charAt(i) == this.word.charAt(i)) {
                output += Constants.ANSI_GREEN + String.valueOf(guess.charAt(i)) + Constants.ANSI_RESET; //review how to compare chars
                added = true;
            }
            if (!added) {
                for (int j=0; j < guess.length(); j++) {
                    if (guess.charAt(i) == this.word.charAt(j)) {
                        output += Constants.ANSI_YELLOW + "+" + Constants.ANSI_RESET;
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
        Console a = System.console();
        String word = new String(a.readPassword("Input a word: "));
        String highlighted_word = "";
        for (char ch : word.toCharArray()) {
            highlighted_word += Constants.ANSI_GREEN + ch + Constants.ANSI_RESET;
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
