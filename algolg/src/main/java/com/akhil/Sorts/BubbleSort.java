package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class BubbleSort extends Sort {
    
    public Queue<Integer> Sort(Queue<Integer> data) {

        Node<Integer> node = data.tail.next;

        while (node != null) {

            if (node.data < node.prev.data) {
                data.swap(node, node.prev);
            }

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
