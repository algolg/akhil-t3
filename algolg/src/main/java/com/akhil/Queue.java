package com.akhil;

import java.util.ArrayList;
import java.util.Scanner;

public class Queue {
    private String queue;

    public Queue() {
        this.queue = "";
    }

    public String getQueue() {
        return this.queue;
    }
    
    public void modify(String change) {
        String[] array = queue.split(" ");
        ArrayList<String> list = new ArrayList();
        for (String word : array) {
            list.add(word);
        }
        boolean exists = false;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) == change) {
                list.remove(i);
                exists = true;
            }
        }
        if (!exists) {
            list.add(change);
        }
        queue = "";
        for (String word : list) {
            queue += word + " ";
        }
    }

    public static void main(String[] args) {
        boolean done = false;
        Queue q = new Queue();
        System.out.println("Type \"EXIT\" to return to menu");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enqueued Data: ");
            String input = sc.nextLine();
            if (input == "EXIT") {
                done = true;
            }
            else {
                q.modify(input);
            }
            System.out.println("Word count: " + (q.getQueue().split(" ").length-1) + ", data: " + q.getQueue());
        } while (!done);
        
    }
}
