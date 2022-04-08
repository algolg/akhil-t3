package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;
import com.akhil.DataTypes.Node;

public class Sort {
    protected static Queue<Integer> data = new Queue<>();
    protected Queue<Integer> sorted = new Queue<>();
    protected Queue<Long> times = new Queue<>();
    private long start;
    private long end;
    
    public void generateData(int len) {
        data.clear();
        for (int i=0; i<len; i++) {
            data.enqueue( (int) (Math.random()*10000) );
            // data.enqueue( 9-i );
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

        // Bubble Comparison
        int maximumComparisons_bubble = 0;
        int minimumComparisons_bubble = 0;
        int totalComparisons_bubble = 0;
        // Selection Comparison
        int maximumComparisons_selection = 0;
        int minimumComparisons_selection = 0;
        int totalComparisons_selection = 0;
        // Merge Comparison
        int maximumComparisons_merge = 0;
        int minimumComparisons_merge = 0;
        int totalComparisons_merge = 0;
        // Bubble Swaps
        int maximumSwaps_bubble = 0;
        int minimumSwaps_bubble = 0;
        int totalSwaps_bubble = 0;
        // Selection Swaps
        int maximumSwaps_selection = 0;
        int minimumSwaps_selection = 0;
        int totalSwaps_selection = 0;
        // Merge Swaps
        int maximumSwaps_merge = 0;
        int minimumSwaps_merge = 0;
        int totalSwaps_merge = 0;

        for (int i=0; i<12; i++) {
            System.out.println("TRIAL #" + (i+1));
            sort.generateData(5000);
            System.out.println("Selection Sort:\t" + selection);
            System.out.println("Merge Sort:\t"     + merge);
            System.out.println("Bubble Sort:\t"    + bubble);
            System.out.println();

            // Bubble Comparison
            minimumComparisons_bubble = Math.min(minimumComparisons_bubble, bubble.getComparisonCount());
            maximumComparisons_bubble = Math.max(bubble.getComparisonCount(), maximumComparisons_bubble);
            totalComparisons_bubble += bubble.getComparisonCount();
            // Selection Comparison
            minimumComparisons_selection = Math.min(minimumComparisons_selection, selection.getComparisonCount());
            maximumComparisons_selection = Math.max(selection.getComparisonCount(), maximumComparisons_selection);
            totalComparisons_selection += selection.getComparisonCount();
            // Merge Comparison
            minimumComparisons_merge = Math.min(minimumComparisons_merge, merge.getComparisonCount());
            maximumComparisons_merge = Math.max(merge.getComparisonCount(), maximumComparisons_merge);
            totalComparisons_merge += merge.getComparisonCount();
            // Bubble Swaps
            minimumSwaps_bubble = Math.min(minimumSwaps_bubble, bubble.getSwapsCount());
            maximumSwaps_bubble = Math.max(bubble.getSwapsCount(), maximumSwaps_bubble);
            totalSwaps_bubble += bubble.getSwapsCount();
            // Selection Swaps
            minimumSwaps_selection = Math.min(minimumSwaps_selection, selection.getSwapsCount());
            maximumSwaps_selection = Math.max(selection.getSwapsCount(), maximumSwaps_selection);
            totalSwaps_selection += selection.getSwapsCount();
            // Merge Swaps
            minimumSwaps_merge = Math.min(minimumSwaps_merge, merge.getSwapsCount());
            maximumSwaps_merge = Math.max(merge.getSwapsCount(), maximumSwaps_merge);
            totalSwaps_merge += merge.getSwapsCount();
        }
        // Comparisons
        int averageComparisons_bubble = (totalComparisons_bubble - minimumComparisons_bubble - maximumComparisons_bubble) / 10;
        int averageComparisons_selection = (totalComparisons_selection - minimumComparisons_selection - maximumComparisons_selection) / 10;
        int averageComparisons_merge = (totalComparisons_merge - minimumComparisons_merge - maximumComparisons_merge) / 10;
        // Swaps
        int averageSwaps_bubble = (totalSwaps_bubble - minimumSwaps_bubble - maximumSwaps_bubble) / 10;
        int averageSwaps_selection = (totalSwaps_selection - minimumSwaps_selection - maximumSwaps_selection) / 10;
        int averageSwaps_merge = (totalSwaps_merge - minimumSwaps_merge - maximumSwaps_merge) / 10;

        System.out.println("AVERAGES (EXCL. MAX AND MIN)");
        System.out.println("Selection Sort:\t" + selection.averageTimes(selection.getTimes()) + " ns, " + averageComparisons_bubble + " comparisons, " + averageSwaps_bubble + " swaps");
        System.out.println("Bubble Sort:\t"    + bubble.averageTimes(bubble.getTimes())       + " ns, " + averageComparisons_selection + " comparisons, " + averageSwaps_selection + " swaps");
        System.out.println("Merge Sort:\t"     + "    " + merge.averageTimes(merge.getTimes())         + " ns, " + averageComparisons_merge + " comparisons, " + averageSwaps_merge + " swaps");
    }
}
