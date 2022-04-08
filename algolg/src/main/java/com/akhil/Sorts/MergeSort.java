package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class MergeSort extends Sort {
    
    public Queue<Integer> Sort(Queue<Integer> data) {
        Queue<Integer> sorted = new Queue<>();
        Node<Integer> i;

        Queue<Integer> qOne = new Queue<>();
        Queue<Integer> qTwo = new Queue<>();

        i = data.tail;
        for (int j=0; j<(data.size())/2; j++) {
            qTwo.enqueue(i.data);
            i = i.next;
        }
        while (i != null) {
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

        sorted = Queue.merge(qOne, qTwo);

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
        sort.generateData(10);
        System.out.println(sort);
    }
}
