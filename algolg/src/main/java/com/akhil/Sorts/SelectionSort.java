package com.akhil.Sorts;

import com.akhil.DataTypes.Node;
import com.akhil.DataTypes.Queue;

public class SelectionSort extends Sort {
    private int split = 0;

    public Queue<Integer> Sort(Queue<Integer> data) {
        Node<Integer> lowest = new Node<>(Integer.MAX_VALUE);
        Node<Integer> node = data.getNode(split);
        while (node != null) {
            if (node.data != null) {
                if (node.data < lowest.data) {
                    lowest = node;
                }
            }
            node = node.next;
        }
        data.swap(lowest, data.getNode(split));
        split++;
        if (!sortChecker(data)) {
            Sort(data);
        }
        return data;
    }

    public String toString() {
        Queue<Integer> set = data.clone();
        this.split = 0;
        setStartTime();
        sorted = Sort(set);
        setEndTime();
        times.enqueue(getTimeElapsed());
        // return(getSort() + " in " + getTimeElapsed());
        return("Sorted in " + getTimeElapsed() + " ns");
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        sort.generateData(5000);
        System.out.println(sort);
    }
}
