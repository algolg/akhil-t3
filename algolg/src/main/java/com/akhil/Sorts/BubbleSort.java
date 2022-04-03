package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Stack;

public class BubbleSort extends Sort {
    
    public void Sort(Queue<Integer> data) {
        Queue<Integer> temp = new Queue<>();
        Stack<Integer> newData = new Stack<>();
        Queue<Integer> newDataQ = new Queue<>();

        boolean found = false;
        int previous = -1;
        for (int i : data) {
            if (!found) {
                newData.push(i);
            }
            else {
                temp.enqueue(i);
            }
            if (i < previous) {
                found = true;
            }
            previous = i;
        }

        int smaller = newData.peek();
        newData.pop();
        int bigger = newData.peek();
        newData.pop();
        newData.push(smaller);
        newData.push(bigger);


        while (temp.size()>0) {
            newData.push(temp.peek());
            temp.dequeue();
        }


        for (int i : newData) {
            newDataQ.enqueue(i);
        }
        sorted = newDataQ;

        if (!sortChecker(newDataQ)) {
            Sort(newDataQ);
        }

    }

    public String toString() {
        setStartTime();
        Sort(getData());
        setEndTime();
        return(getSort() + " in " + getTimeElapsed());
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.generateData();
        System.out.println(sort);
    }
}
