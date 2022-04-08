package com.akhil.DataTypes;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue<T> {
    public Node<T> tail = new Node<>();
    public Node<T> head = new Node<>();
    public int length = 0;
    
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
        first.data = second.data;
        second.data = temp;
    }

    public Node<T> getNode(int index) {
        Node<T> node = this.tail;

        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        for (int i=0; i<index; i++) {
            node = node.next;
        }

        return node;
    }

    public void clear() {
        this.tail = new Node<T>();
        this.head = new Node<T>();
        this.length = 0;
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

    public Queue<T> clone() {
        Queue<T> output = new Queue<>();
        Node<T> node = this.tail;
        while (node != null) {
            output.enqueue(node.data);
            node = node.next;
        }
        return output;
    }

    public static Queue<Integer> merge(Queue<Integer> first, Queue<Integer> second) {
        Queue<Integer> output = new Queue<>();
        Node<Integer> firstNode = first.tail;
        Node<Integer> secondNode = second.tail;

        while (firstNode != null && secondNode != null) {
            if (firstNode.data < secondNode.data) {
                output.enqueue(firstNode.data);
                firstNode = firstNode.next;
            }
            else {
                output.enqueue(secondNode.data);
                secondNode = secondNode.next;
            }
        }
        while (firstNode != null) {
            output.enqueue(firstNode.data);
            firstNode = firstNode.next;
        }
        while (secondNode != null) {
            output.enqueue(secondNode.data);
            secondNode = secondNode.next;
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
