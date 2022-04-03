package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;

public class SelectionSort extends Sort {

    public void Sort(Queue<Integer> data) {
        int lowest = Integer.MAX_VALUE;
        for (int i : data) {
            if (i < lowest) {
                lowest = i;
            }
        }
        sorted.enqueue(lowest);
        Queue<Integer> newData = new Queue<>();
        int appeared = 0;
        for (int i : data) {
            if (i != lowest || appeared != 0) {
                newData.enqueue(i);
            }
            else if (i == lowest) {
                appeared++;
            }
        }
        if (newData.size() > 0) {
            Sort(newData);
        }

    }

    public String toString() {
        setStartTime();
        Sort(getData());
        setEndTime();
        return(getSort() + " in " + getTimeElapsed());
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        sort.generateData();
        System.out.println(sort);
    }
}
