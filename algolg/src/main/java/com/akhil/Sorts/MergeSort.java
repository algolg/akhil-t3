package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class MergeSort extends Sort {
    
    public Queue<Integer> Sort(Queue<Integer> data) {
        Queue<Integer> sorted = new Queue<>();
        Node<Integer> i;

        int sta = 0;
        int mid = data.size()/2;
        int end = data.size();

        int halfOne = mid - sta;
        int halfTwo = end - mid;

        Queue<Integer> qOne = new Queue<>();
        Queue<Integer> qTwo = new Queue<>();

        i = data.tail;
        for (int j=0; j<halfTwo; j++) {
            qTwo.enqueue(i.data);
            i = i.next;
        }
        for (int j=0; j<halfOne; j++) {
            qOne.enqueue(i.data);
            i = i.next;
        }
        // System.out.println(qOne.formattedString());
        // System.out.println(qTwo.formattedString());

        if (qOne.size()>1) {
            qOne = Sort(qOne);
        }
        if (qTwo.size()>1) {
            qTwo = Sort(qTwo);
        }

        while (qOne.peek() != null && qTwo.peek() != null) {
            if (qOne.peek().data <= qTwo.peek().data) {
                sorted.enqueue(qOne.peek().data);
                qOne.dequeue();
            }
            else {
                sorted.enqueue(qTwo.peek().data);
                qTwo.dequeue();
            }
        }

        i = qOne.tail;
        while (i != null) {
            sorted.enqueue(i.data);
            i = i.next;
        }
        i = qTwo.tail;
        while (i != null) {
            sorted.enqueue(i.data);
            i = i.next;
        }

        // System.out.println(sorted.formattedString());

        return sorted;
    }

    public String toString() {
        setStartTime();
        sorted = Sort(getData());
        setEndTime();
        times.enqueue(getTimeElapsed());
        // return(getSort() + " in " + getTimeElapsed());
        return("Sorted in " + getTimeElapsed() + " ns");
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.generateData(5000);
        System.out.println(sort);
    }
}
