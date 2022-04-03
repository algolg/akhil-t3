package com.akhil.Sorts;

import javax.xml.crypto.Data;

import com.akhil.DataTypes.Queue;

public class BubbleSort extends Sort {
    private Queue<Integer> sorted = new Queue<>();

    public void Sort(Queue<Integer> data) {
        int index = 0;
        int first = 0;
        int second = 0;
        System.out.println(sorted.formattedString());
        for (int i : data) {
            if (index == 0) {
                first = i;
            }
            else if (index == 1) {
                second = i;
            }
            else if (index > 1) {
                break;
            }
            index++;
        }
        if (data.size()>0) {
            data.dequeue();
        }
        if (data.size()>0) {
            data.dequeue();
        }
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
        boolean done = true;
        int previous = 0;
        for (int i : sorted) {
            if (i < previous) {
                done = false;
            }
            previous = i;
        }
        if (!done) {
            Sort(sorted);
        }

    }

    public Queue<Integer> getData() {
        return data;
    }

    public String getSort() {
        return sorted.formattedString();
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.generateData();
        sort.Sort(sort.getData());
        System.out.println(sort.getSort());
    }
}
