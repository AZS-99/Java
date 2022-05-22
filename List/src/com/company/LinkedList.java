package com.company;

public class LinkedList<T>{
    private Node<T> head;
    private Node<T> tail;

    LinkedList() {
        head = tail = null;
    }

    public String toString() {
        var current = head;
        var string = "[";
        while (current != null) {
            string += current.value.toString() + (current.nxt != null? ", " : "");
            current = current.nxt;
        }
        return string + ']';
    }

    void append(T value) {
        var node = new Node<T>(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.nxt = node;
            tail = tail.nxt;
        }
    }



}
