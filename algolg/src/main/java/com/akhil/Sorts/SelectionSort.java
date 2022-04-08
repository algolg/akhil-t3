package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class SelectionSort extends Sort {

    public void Sort(Queue<Integer> data) {
        Node<Integer> lowest = new Node<>(Integer.MAX_VALUE);
        Node<Integer> node = data.tail;
        while (node != null) {
            if (node.data != null) {
                if (node.data < lowest.data) {
                    lowest = node;
                }
            }
            node = node.next;
        }
        sorted.enqueue(lowest.data);
        lowest.data = null;
        if (sorted.size() < data.size()) {
            Sort(data);
        }
    }

    public String toString() {
        setStartTime();
        Sort(getData());
        setEndTime();
        times.enqueue(getTimeElapsed());
        return(getSort() + " in " + getTimeElapsed());
        // return("Sorted in " + getTimeElapsed() + " ns");
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        sort.generateData(5000);
        System.out.println(sort);
    }
}
