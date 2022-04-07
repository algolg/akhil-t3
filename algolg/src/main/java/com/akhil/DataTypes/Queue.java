package com.akhil.DataTypes;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue<T> {
    public Node<T> tail = new Node<>();
    public Node<T> head = new Node<>();
    private int length = 0;
    
    public void enqueue(T data) {
        enqueue(new Node<T>(data));
    }

    public void enqueue(Node<T> data) {
        if (length == 0) {
            this.tail = data;
            tail.prev = null;
            tail.next = null;
        }
        else if (head.prev == null) {
            this.head = data;
            head.prev = tail;
            tail.next = head;
        }
        else {
            head.next = data;
            data.prev = head;
            head = data;
            head.next = null;
        }
        length++;

    }

    public void dequeue() {
        tail = tail.next;
        length--;
    }

    public Node<T> peek() {
        return tail;
    }

    public void swap(Node<T> first, Node<T> second) {
        T temp = first.data;
        T otherTemp = second.data;
        Node<T> node = this.tail;
        while (node != null) {
            if (node.equals(first)) {
                node.data = otherTemp;
            }
            else if (node.equals(second)) {
                node.data = temp;
            }
            node = node.next;
        }
    }

    public int size() {
        return length;
    }

    public String toString() {
        String output = "";
        Node<T> node = tail;
        while (node != null) {
            output += node.data + " ";
            node = node.next;
        }
        return output;
    }

    public String formattedString() {
        String output = "[";
        Node<T> node = tail;
        while (node != null) {
            output += node.data + ", ";
            node = node.next;
        }
        output = output.substring(0, output.length()-2) + "]";
        return output;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(new Node<Integer>(1));
        queue.enqueue(new Node<Integer>(2));
        queue.enqueue(new Node<Integer>(3));
        queue.enqueue(new Node<Integer>(4));
        queue.enqueue(new Node<Integer>(5));
        System.out.println(queue.formattedString());
        queue.swap(queue.tail, queue.tail.next);
        System.out.println(queue.formattedString());
    }
}
