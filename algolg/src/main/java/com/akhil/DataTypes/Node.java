package com.akhil.DataTypes;

public class Node<T> {
    public Node<T> prev;
    public Node<T> next;
    public T data;

    public Node() {
        this.prev = null;
        this.next = null;
        this.data = null;
    }

    public Node(Node<T> prev, Node<T> next, T data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public Node(T data) {
        this.prev = null;
        this.next = null;
        this.data = data;
    }
    
}
