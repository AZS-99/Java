package com.company;

public class List <T> {
    private Node<T> head;
    private Node<T> tail;

    List() {
        head = tail = null;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("[");
        var current = head;
        while (current != null) {
            string.append(current.value.toString());
            string.append(" ");
            current = current.nxt;
        }
        string.append(']');
        return string.toString();
    }

    public void append(T value) {
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            tail.nxt = new Node<>(value);
            tail = tail.nxt;
        }
    }

    public void prepend(T value) {
        if (head == null)
            head = tail = new Node<>(value);
        else {
            var node = new Node<>(value);
            node.nxt = head;
            head = node;
        }
    }
}
