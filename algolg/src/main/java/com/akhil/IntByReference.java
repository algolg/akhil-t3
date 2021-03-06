package com.akhil;

public class IntByReference {
    private int value;

    // Hack: create IntByReference, swapToLowHighOrder and toString methods
    public IntByReference(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void swapToLowHighOrder(IntByReference b) {
        if (this.getValue() > b.getValue()) {
            int temp = this.getValue();
            this.setValue(b.getValue());
            b.setValue(temp);
        }
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    // static method that enables me to see numbers swapped by reference (before, after)
    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a + " " + b);
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a + " " + b);
        System.out.println();
    }

    // static main method that provides some simple test cases
    public static void main(String[] ags) {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }
}