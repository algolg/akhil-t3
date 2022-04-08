package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class SelectionSort extends Sort {

    public void Sort(Queue<Integer> data) {
        int lowest = Integer.MAX_VALUE;
        Node<Integer> node = data.tail;
        while (node != null) {
            if (node.data < lowest) {
                lowest = node.data;
            }
            node = node.next;
        }
        sorted.enqueue(lowest);
        Queue<Integer> newData = new Queue<>();
        int appeared = 0;
        node = data.tail;
        while (node != null) {
            if (node.data != lowest || appeared != 0) {
                newData.enqueue(node.data);
            }
            else if (node.data == lowest) {
                appeared++;
            }
            node = node.next;
        }
        if (newData.size() > 0) {
            Sort(newData);
        }

    }

    public String toString() {
        setStartTime();
        Sort(getData());
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
