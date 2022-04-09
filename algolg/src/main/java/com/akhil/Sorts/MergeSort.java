package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class MergeSort extends Sort {

    public int comparisonCount = 0;
    
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

        sorted = merge(qOne, qTwo);

        // System.out.println(sorted.formattedString());

        return sorted;
    }

    public Queue<Integer> merge(Queue<Integer> first, Queue<Integer> second) {
        Queue<Integer> output = new Queue<>();
        Node<Integer> firstNode = first.tail;
        Node<Integer> secondNode = second.tail;

        while (firstNode != null && secondNode != null) {
            comparisonCount++;
            if (firstNode.data < secondNode.data) {
                output.enqueue(firstNode.data);
                firstNode = firstNode.next;
            }
            else {
                output.enqueue(secondNode.data);
                secondNode = secondNode.next;
            }
        }
        while (firstNode != null) {
            output.enqueue(firstNode.data);
            firstNode = firstNode.next;
        }
        while (secondNode != null) {
            output.enqueue(secondNode.data);
            secondNode = secondNode.next;
        }
        return output;
    }

    public String toString() {
        comparisonCount = 0;
        Queue<Integer> set = data.clone();
        setStartTime();
        sorted = Sort(set);
        setEndTime();
        times.enqueue(getTimeElapsed());
        // return(getSort() + " in " + getTimeElapsed());
        return("    Sorted in " + getTimeElapsed() + " ns, " + comparisonCount + " comparisons, 0 swaps");
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapsCount() {
        return 0;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.generateData(5000);
        System.out.println(sort);
    }
}
