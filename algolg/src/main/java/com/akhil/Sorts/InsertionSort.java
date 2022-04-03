package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;

public class InsertionSort extends Sort {
    private Queue<Integer> sorted = new Queue<>();

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

    public String getSort() {
        return sorted.formattedString();
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        sort.generateData();
        sort.Sort(sort.getData());
        System.out.println(sort.getSort());
    }
}
