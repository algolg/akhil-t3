package com.akhil.Sorts;

import javax.xml.crypto.Data;

import com.akhil.DataTypes.Queue;

public class BubbleSort extends Sort {
    private Queue<Integer> sorted = new Queue<>();

    public void Sort(Queue<Integer> data, int start) {
        int index = start;
        int first = 0;
        int second = 0;
        System.out.println(data.formattedString());
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

    public Queue<Integer> getData() {
        return data;
    }

    public String getSort() {
        return sorted.formattedString();
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.generateData();
        sort.Sort(sort.getData(), 0);
        System.out.println(sort.getSort());
    }
}
