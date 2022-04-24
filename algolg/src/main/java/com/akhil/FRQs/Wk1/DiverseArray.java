package com.akhil.FRQs.Wk1;

public class DiverseArray {
    
    public static int arraySum(int[] arr) {
        int total = 0;
        for (int i : arr)
            total += i;
        return total;
    }

    public static int[] rowSums(int[][] arr2D) {
        int arr[] = new int[arr2D.length]; //review initializing arrays lol
        for (int i=0; i < arr2D.length; i++)
            arr[i] = DiverseArray.arraySum(arr2D[i]);
        return arr;
    }

    public static boolean isDiverse(int[][] arr2D) {
        int sums[] = DiverseArray.rowSums(arr2D);
        for (int i=0; i < sums.length-1; i++)
            for (int j=i+1; j<sums.length; j++)
                if (sums[i] == sums[j])
                    return false;
        return true;
    }

    public static void main(String[] args) {
        int arr[][] = new int[5][5];
        System.out.println("\nGenerated the following array (sums shown on right)");
        for (int[] i : arr) {
            for (int j=0; j < i.length; j++) {
                i[j] = (int) (10 * Math.random());
                System.out.print(i[j] + " ");
            }
            System.out.println("\t" + DiverseArray.arraySum(i));
        }
        System.out.println("The array is " + (DiverseArray.isDiverse(arr) ? "" : "not ") + "diverse");
    }

}