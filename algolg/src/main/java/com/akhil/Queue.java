package com.akhil;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Queue {
    private String queue;

    public Queue() {
        this.queue = "";
    }

    public Queue(String queue) {
        this.queue = queue;
    }

    public String getQueue() {
        return this.queue;
    }

    public Queue sortQueue(Queue that) {
        String a = this.getQueue();
        String b = that.getQueue();
        String[] aList = a.split(" ");
        String[] bList = b.split(" ");
        ArrayList<Integer> fullList = new ArrayList<>();

        for (String i : aList) {
            fullList.add(Integer.parseInt(i));
        }
        for (String i : bList) {
            fullList.add(Integer.parseInt(i));
        }

        boolean done = true;
        do {
            done = true;
            for (int i=0; i<fullList.size()-1; i++) {
                if (fullList.get(i+1) < fullList.get(i)) {
                    done = false;
                    int sec = fullList.get(i+1);
                    int fir = fullList.get(i);
                    fullList.set(i+1, fir);
                    fullList.set(i, sec);
                }
            }
        } while (!done);

        String output = "";
        for (int i=0; i<fullList.size()-1; i++) {
            output += fullList.get(i) + " ";
        }
        output += fullList.get(fullList.size()-1);
        Queue outputQueue = new Queue(output);
        return outputQueue;
    }
    
    public void modify(String change) {
        ArrayList<String> list = new ArrayList();
        if (queue.length()>0) {
            String[] array = queue.split(" ");
            for (String word : array) {
                list.add(word);
            }
        }
        boolean exists = false;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals(change)) {
                list.remove(i);
                exists = true;
            }
        }
        if (!exists) {
            list.add(change);
        }
        queue = "";
        for (int i=0; i<list.size()-1;i++) {
            queue += list.get(i) + " ";
        }
        queue += list.get(list.size()-1);
    }

    public Queue reverseQueue() {
        String[] array = queue.split(" ");
        String reverse = "";
        for (int i=array.length-1;i>0;i--) {
            reverse += array[i] + " ";
        }
        reverse += array[0];
        Queue reverseQueue = new Queue(reverse);
        return reverseQueue;
    }

    public static void main(String[] args) {
        boolean done = false;
        Queue q = new Queue();
        System.out.println("Type \"EXIT\" to return to menu");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enqueued Data: ");
            String input = sc.nextLine();
            if (input.equals("EXIT")) {
                done = true;
            }
            else {
                q.modify(input);
            }
            System.out.println("Word count: " + (q.getQueue().split(" ").length-1) + ", data: " + q.getQueue());
        } while (!done);
        
    }

    public static void sort(String[] args) {
        boolean done = false;
        Queue firstQ = new Queue();
        System.out.println("Write the first queue of integers");
        System.out.println("Type \"DONE\" to continue");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enqueued Data: ");
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                firstQ.modify(String.valueOf(input));
            }
            else if(sc.hasNextLine()) {
                String input = sc.nextLine();
                if (input.equals("DONE")) {
                    done = true;
                }
            }
            System.out.println("Word count: " + (firstQ.getQueue().split(" ").length-1) + ", data: " + firstQ.getQueue());
        } while (!done);
        System.out.println();

        done = false;
        Queue secQ = new Queue();
        System.out.println("Write the second queue of integers");
        System.out.println("Type \"DONE\" to continue");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enqueued Data: ");
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                secQ.modify(String.valueOf(input));
            }
            else if(sc.hasNextLine()) {
                String input = sc.nextLine();
                if (input.equals("DONE")) {
                    done = true;
                }
            }
            System.out.println("Word count: " + (secQ.getQueue().split(" ").length-1) + ", data: " + secQ.getQueue());
        } while (!done);

        Queue newQueue = firstQ.sortQueue(secQ);
        System.out.println("New Queue: " + newQueue.getQueue());
    }
    public static void reverse(String[] args) {
        boolean done = false;
        Queue q = new Queue();
        System.out.println("Type \"DONE\" to reverse");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enqueued Data: ");
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                q.modify(String.valueOf(input));
            }
            else if(sc.hasNextLine()) {
                String input = sc.nextLine();
                if (input.equals("DONE")) {
                    done = true;
                }
            }
            System.out.println("Word count: " + (q.getQueue().split(" ").length-1) + ", data: " + q.getQueue());
        } while (!done);
        System.out.println("Reversed Queue: " + q.reverseQueue().getQueue());
    }

    public static void menu(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Menu> menu = new HashMap<>();

        menu.put(0, new Menu("Exit", () -> Menu.main(null) ) );
        menu.put(1, new Menu("Queue Main", () -> Queue.main(null) ) );
        menu.put(2, new Menu("Queue Sort", () -> Queue.sort(null) ) );
        menu.put(3, new Menu("Queue Reverse", () -> Queue.reverse(null) ) );

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
