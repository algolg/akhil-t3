package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Stack;

public class BubbleSort extends Sort {
    
    public Queue<Integer> Sort(Queue<Integer> data) {

        // Iterate like a bubble sort
        for (int j = 1; j < data.size(); j++) {
            for (int i = 0; i < data.size() - j; i++) {
                // Look at the current value and the next value in the queue
                int temp = data.peek();
                data.dequeue();
                int tempPlusOne = data.peek();

                // System.out.println to see if it's actually doing anything
                System.out.println("Something");

                // If they're out of order, Swap em
                if (temp > tempPlusOne) {
                    data.dequeue();
                    data.enqueue(temp);
                    data.enqueue(tempPlusOne);
                }
                // If they're fine, don't swap em, put back the thing I dequeued
                else {
                    data.enqueue(temp);
                }
            }
        }

        return data;
        /*
        Queue<Integer> temp = new Queue<>();
        Stack<Integer> newData = new Stack<>();
        Queue<Integer> newDataQ = new Queue<>();

        boolean found = false;
        int previous = -1;
        for (int i : data) {
            if (!found) {
                newData.push(i);
            }
            else {
                temp.enqueue(i);
            }
            if (i < previous) {
                found = true;
            }
            previous = i;
        }

        int smaller = newData.peek();
        newData.pop();
        int bigger = newData.peek();
        newData.pop();
        newData.push(smaller);
        newData.push(bigger);

        while (temp.size()>0) {
            newData.push(temp.peek());
            temp.dequeue();
        }

        for (int i : newData) {
            newDataQ.enqueue(i);
        }
        return newDataQ;
        */

        // System.out.println(sorted.formattedString());
        // System.out.println();

        // if (!sortChecker(newDataQ)) {
        //     Sort(newDataQ);
        // }
    }

    public void Sorter(Queue<Integer> data) {
        while (!sortChecker(data)) {
            data = Sort(data);
        }
        sorted = data;
    }

    public String toString() {
        setStartTime();
        Sorter(getData());
        setEndTime();
        times.enqueue(getTimeElapsed());
        // return(getSort() + " in " + getTimeElapsed());
        return("Sorted in " + getTimeElapsed() + " ns");
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.generateData();
        System.out.println(sort);
    }
}
