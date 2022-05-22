package com.company;

public class Node<T> {
    T value;
    Node<T> nxt;

    public Node(T value) {
        this.value = value;
        nxt = null;
    }

    public String toString() {
        return value.toString();
    }
}
