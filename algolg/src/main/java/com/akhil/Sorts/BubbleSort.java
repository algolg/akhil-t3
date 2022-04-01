package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;

public class BubbleSort extends Sort {
    private Queue<Integer> sorted = new Queue<>();

    public void Sort(Queue<Integer> data, int start) {
        int index = start;
        int first = 0;
        int second = 0;
        for (int i : data) {
            if (index == start) {
                first = i;
            }
            else if (index == start+1) {
                second = i;
            }
            else if (index > start+1) {
                break;
            }
            index++;
        }
        data.dequeue();
        data.dequeue();
        if (first > second) {
            sorted.enqueue(second);
            sorted.enqueue(first);
        }
        else {
            sorted.enqueue(first);
            sorted.enqueue(second);
        }
        for (int i : data) {
            sorted.enqueue(i);
        }
        boolean done = false;
        int previous = 0;
        for (int i : sorted) {
            if (i < previous) {
                done = true;
            }
            previous = i;
        }
        if (done) {
            Sort(data, start+1);
        }

    }
}
