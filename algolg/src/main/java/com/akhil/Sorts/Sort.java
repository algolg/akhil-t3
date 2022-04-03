package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;

public class Sort {
    protected Queue<Integer> data = new Queue<>();
    
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

}
