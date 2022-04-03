package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;

public class Sort {
    protected static Queue<Integer> data = new Queue<>();
    protected Queue<Integer> sorted = new Queue<>();
    private long start;
    private long end;
    
    public void generateData() {
        for (int i=0; i<10; i++) {
            // data.enqueue( (int) (Math.random()*1000) );
            data.enqueue( 9-i );
        }
    }

    public Queue<Integer> getData() {
        return data;
    }

    public boolean sortChecker(Queue<Integer> sort) {
        boolean done = true;
        int previous = -1;
        for (int i : sort) {
            if (i < previous) {
                done = false;
                break;
            }
            previous = i;
        }
        return done;
    }

    public int anomoly(Queue<Integer> sort) {
        // int index = 0;
        int output = -1;
        int previous = -1;
        for (int i : sort) {
            if (i < previous) {
                // output = index;
                output = i;
                break;
            }
            // index++;
            previous = i;
        }
        return output;
    }

    public String getSort() {
        return sorted.formattedString();
    }

    public void setStartTime() {
        this.start = System.nanoTime();
    }

    public void setEndTime() {
        this.end = System.nanoTime();
    }

    public long getTimeElapsed() {
        return this.end - this.start;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        SelectionSort selection = new SelectionSort();
        BubbleSort bubble = new BubbleSort();

        sort.generateData();
        System.out.println("Selection Sort:\n" + selection);
        System.out.println("Bubble Sort:\n" + bubble);
    }
}
