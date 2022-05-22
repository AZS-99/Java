package com.company;

public class Node<T>{
    T value;
    Node<T> right;
    Node<T> left;

    Node(T value) {
        this.value = value;
    }
}
