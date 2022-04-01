package com.akhil.DataTypes;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T e) {
        this.stack.add(e);
    }

    public void pop() {
        this.stack.remove(this.stack.size()-1);
    }

    public T peek() {
        if (stack.size() > 0) {
            return this.stack.get(this.stack.size()-1);
        }
        else {
            return null;
        }
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

    public String formattedString() {
        String output = "[";
        for (Object i : stack) {
            output += i + ", ";
        }
        output = output.substring(0, output.length()-2) + "]";
        return output;
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }
}
