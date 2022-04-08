package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class BubbleSort extends Sort {

    public int swapCount = 0;
    public int comparisonCount = 0;
    
    public Queue<Integer> Sort(Queue<Integer> data) {

        Node<Integer> node = data.tail.next;

        while (node != null) {

            if (node.data < node.prev.data) {
                data.swap(node, node.prev);
                swapCount += 1;
            }
            comparisonCount += 1;

            node = node.next;
        }
        return data;
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
        Queue<Integer> set = data.clone();
        setStartTime();
        Sorter(set);
        setEndTime();
        times.enqueue(getTimeElapsed());
        // return(getSort() + " in " + getTimeElapsed());
        return("Sorted in " + getTimeElapsed() + " ns, " + comparisonCount + " comparisons, " + swapCount + " swaps");
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapsCount() {
        return swapCount;
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.generateData(5000);
        System.out.println(sort);
    }
}
