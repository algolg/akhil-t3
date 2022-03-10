package com.akhil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.RunnableFuture;

public class Menu {
    String title;
    Runnable action;
    private static Boolean done = false;

    public Menu(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title;
    }

    public Runnable getAction() {
        return this.action;
    }

    public static void exit() {
        done = true;
    }

    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);

            Map<Integer, Menu> menu = new HashMap<>();

            menu.put(0, new Menu("Exit", () -> Menu.exit() ) );
            menu.put(1, new Menu("Matrix", () -> Matrix.main(null) ) );
            menu.put(2, new Menu("Calculator", () -> Calculator.main(null) ) );

            System.out.println("Menu:");
            for (Map.Entry<Integer, Menu> pair : menu.entrySet()) {
                System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
            }
            int input = sc.nextInt();
            try {
                Menu m = menu.get(input);
                m.getAction().run();
            } catch (Exception e) {
                System.out.println("error");
                
            }
        } while(!done);
    }
}