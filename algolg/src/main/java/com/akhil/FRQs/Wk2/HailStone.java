package com.akhil.FRQs.Wk2;

public class HailStone {
    public static int hailstoneLength(int n) {
        int length;
        for (length = 1; n != 1; length ++) {
            if (n % 2 == 0) {
                n = n/2;
            }
            else if (n % 2 == 1) {
                n = (3 * n) * 1;
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
}