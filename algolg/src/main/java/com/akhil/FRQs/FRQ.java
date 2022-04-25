package com.akhil.FRQs;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

import com.akhil.Menu;
import com.akhil.FRQs.Wk1.*;

public class FRQ {
    
    public static void menu(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Menu> menu = new HashMap<>();

        menu.put(0, new Menu("Exit", () -> Menu.main(null) ) );
        menu.put(1, new Menu("DiverseAray", () -> DiverseArray.main(null) ) );
        menu.put(2, new Menu("HiddenWord", () -> HiddenWord.main(null) ) );
        menu.put(3, new Menu("SparseArray", () -> SparseArray.main(null) ) );
        menu.put(4, new Menu("Range", () -> Range.main(null) ) );

        System.out.println("Menu:");
        for (Map.Entry<Integer, Menu> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
        }

        if (sc.hasNextInt()) {
            int input = sc.nextInt();
            if ( input >= 0 && menu.size() > input ) {
                Menu m = menu.get(input);
                m.getAction().run();
                System.out.println();
            } else {
                System.out.println("Error: Expecting an Integer from 0 to " + (menu.size()-1) );
            }
        } else {
            System.out.println("Error: Expecting an Integer from 0 to " + (menu.size()-1) );
        }
        System.out.println();
    }
}
