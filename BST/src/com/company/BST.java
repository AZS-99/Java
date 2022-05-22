package com.company;

import java.util.ArrayList;

public class BST<T extends Comparable<T>>{
    private T value;
    private BST<T> left;
    private BST<T> right;

    BST(T value) {
        this.value = value;
        right = left = null;
    }

    public String toString() {
        var string = "";
        for (int i = 0; i < height(); i++)
            string += printLevel(i) + '\n';
        return string;
    }

    public int size() {
        if (left == null && right == null)
            return 1;
        return (right != null? right.size() : 0) + (left != null? left.size() : 0) + 1;
    }

    public int height() {
        if (right == null && left == null)
            return 1;
        return Math.max(right != null? right.height() : 0, left != null? left.height() : 0) + 1;
    }

    public String printLevel(int level) {
        if (level == 0)
            return value.toString();
        return (left != null? left.printLevel(level - 1) : "") + " " + (right != null? right.printLevel(level - 1) : "");
    }



    public void insert(T value) {
        if (value.compareTo(this.value) > 0) {
            if (right == null)
                right = new BST<>(value);
            else
                right.insert(value);
        } else if (value.compareTo(this.value) < 0) {
            if (left == null)
                left = new BST<>(value);
            else
                left.insert(value);
        }
    }

}
