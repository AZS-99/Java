package com.company;

public class Node <T> {
    T value;
    Node<T> nxt;

    Node(T value) {
        this.value = value;
    }

    public String toString() {
        return nxt == null? value.toString() + "-->|" : String.format("%s --> %s", value, nxt);
    }

    public void append(T value) {
        if (nxt == null)
            nxt = new Node<>(value);
        else
            nxt.append(value);
    }

    public void merge(Node<T> other) {
        if (other == null)
            return;
        nxt.merge(other.nxt);
        other.nxt = nxt;
        nxt = other;
    }


}
