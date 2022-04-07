package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class Sort {
    protected static final Queue<Integer> data = new Queue<>();
    protected Queue<Integer> sorted = new Queue<>();
    protected Queue<Long> times = new Queue<>();
    private long start;
    private long end;
    
    public void generateData() {
        for (int i=0; i<5000; i++) {
            data.enqueue( (int) (Math.random()*5000) );
        }
    }

    public Queue<Integer> getData() {
        return data;
    }

    public boolean sortChecker(Queue<Integer> sort) {
        boolean done = true;
        Node<Integer> node = sort.tail.next;
        while (node != null) {
            if (node.data < node.prev.data) {
                done = false;
                break;
            }
            node = node.next;
        }
        return done;
    }

    // public int anomoly(Queue<Integer> sort) {
    //     // int index = 0;
    //     int output = -1;
    //     int previous = -1;
    //     for (int i : sort) {
    //         if (i < previous) {
    //             // output = index;
    //             output = i;
    //             break;
    //         }
    //         // index++;
    //         previous = i;
    //     }
    //     return output;
    // }

    public String getSort() {
        return sorted.formattedString();
    }

    public void setStartTime() {
        this.start = System.nanoTime();
    }

    public void setEndTime() {
        this.end = System.nanoTime();
    }

    public long getTimeElapsed() {
        return this.end - this.start;
    }

    public Queue<Long> getTimes() {
        return times;
    }

    public long averageTimes(Queue<Long> times) {
        long lowest = Long.MAX_VALUE;
        long highest = 0;
        Queue<Long> newTimes = new Queue<>();
        long sum = 0;

        Node<Long> node = times.tail;
        while (node != null) {
            if (node.data < lowest) {
                lowest = node.data;
            }
            if (node.data > highest) {
                highest = node.data;
            }
            node = node.next;
        }
        node = times.tail;
        while (node != null) {
            if (node.data != lowest && node.data != highest) {
                newTimes.enqueue(node.data);
            }
            node = node.next;
        }
        node = newTimes.tail;
        while (node != null) {
            sum += node.data;
            node = node.next;
        }
        return sum/((long) newTimes.size());
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        SelectionSort selection = new SelectionSort();
        BubbleSort bubble = new BubbleSort();
        MergeSort merge = new MergeSort();

        System.out.println();
        for (int i=0; i<12; i++) {
            sort.generateData();
            System.out.println("TRIAL #" + (i+1));
            System.out.println("Selection Sort:\t" + selection);
            System.out.println("Bubble Sort:\t"    + bubble);
            System.out.println("Merge Sort:\t"     + merge);
            System.out.println();
        }

        System.out.println("AVERAGES (EXCL. MAX AND MIN)");
        System.out.println("Selection Sort:\t" + selection.averageTimes(selection.getTimes()) + " ns");
        System.out.println("Bubble Sort:\t"    + bubble.averageTimes(bubble.getTimes())       + " ns");
        System.out.println("Merge Sort:\t"     + merge.averageTimes(merge.getTimes())         + " ns");
    }
}
