package com.akhil.FRQs.Wk2;

public class HailStone {
    public static int hailstoneLength(int n) {
        int length; // if you want to use the variable the for loop iterates, 
                    // it must be declared outside of the for loop
        for (length = 1; n != 1; length++) {
            if (n % 2 == 0) {
                n = n/2;
            }
            else if (n % 2 == 1) {
                n = (3 * n) + 1;
            }
        }
        return length;
    }
    public static boolean isLongSeq(int n) {
        int length = HailStone.hailstoneLength(n);
        if (length > n) {
            return true;
        }
        return false;
    }
    public static double propLong (int n) {
        int total = 0;
        for (int i=1; i <= n; i++) {
            if (HailStone.isLongSeq(i)) {
                total++;
            }
        }
        return ((double) total)/((double) n);
    }

    public static void main(String[] args) {
        int len = (int) (Math.random() * 10) + 1;
        System.out.println("\nFirst Hailstone Term: " + len);
        System.out.println("Hailstone Length: " + HailStone.hailstoneLength(len));
        System.out.println("This hailstone is " + (HailStone.isLongSeq(len) ? "" : "not ") + "a long sequence");
        System.out.printf(
            "For hailstones of length 1 to %d, a proportion of %f are long hailstones", len, HailStone.propLong(len)
            );
    }
}