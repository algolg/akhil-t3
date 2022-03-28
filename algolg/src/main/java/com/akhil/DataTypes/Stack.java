package com.akhil.DataTypes;
import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T e) {
        this.stack.add(e);
    }

    public void pop() {
        this.stack.remove(this.stack.size()-1);
    }

    public T peek() {
        return this.stack.get(this.stack.size()-1);
    }

    public int size() {
        return this.stack.size();
    }

    public String toString() {
        String output = "";
        for (T i : stack) {
            output += i + " ";
        }
        return output;
    }
}
