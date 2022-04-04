package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;

public class MergeSort extends Sort {
    
    public Queue<Integer> Sort(Queue<Integer> data) {
        Queue<Integer> sorted = new Queue<>();

        int sta = 0;
        int mid = data.size()/2;
        int end = data.size();

        int halfOne = mid - sta;
        int halfTwo = end - mid;

        Queue<Integer> qOne = new Queue<>();
        Queue<Integer> qTwo = new Queue<>();

        for (int i=0; i<halfTwo; i++) {
            qTwo.enqueue(data.peek());
            if (data.size()>0) {
                data.dequeue();
            }
        }
        for (int i=0; i<halfOne; i++) {
            qOne.enqueue(data.peek());
            if (data.size()>0) {
                data.dequeue();
            }
        }
        // System.out.println(qOne.formattedString());
        // System.out.println(qTwo.formattedString());

        if (qOne.size()>1) {
            qOne = Sort(qOne);
        }
        if (qTwo.size()>1) {
            qTwo = Sort(qTwo);
        }

        int i = 0;
        int j = 0;
        while (qOne.peek() != null && qTwo.peek() != null) {
            if (qOne.peek() <= qTwo.peek()) {
                sorted.enqueue(qOne.peek());
                qOne.dequeue();
                i++;
            }
            else {
                sorted.enqueue(qTwo.peek());
                qTwo.dequeue();
                j++;
            }
        }

        while (i < halfOne) {
            sorted.enqueue(qOne.peek());
            if (qOne.size()>0) {
                qOne.dequeue();
            }
            i++;
        }
        while (j < halfTwo) {
            sorted.enqueue(qTwo.peek());
            if (qTwo.size()>0) {
                qTwo.dequeue();
            }
            j++;
        }

        // System.out.println(sorted.formattedString());

        return sorted;
    }

    public String toString() {
        setStartTime();
        sorted = Sort(getData());
        setEndTime();
        // return(getSort() + " in " + getTimeElapsed());
        return("Sorted in " + getTimeElapsed());
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.generateData();
        System.out.println(sort);
    }
}
