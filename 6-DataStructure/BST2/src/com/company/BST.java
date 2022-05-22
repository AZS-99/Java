package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class BST <T extends Comparable<T>>{
    Node<T> root;
    int size;

    BST() {
        root = null;
        size = 0;
    }

    public String toString() {
        var string = "";
        Node<T> parent;
        var children = new ArrayList<Node<T>>();
        ArrayList<Node<T>> parents;
        children.add(root);

        while (!children.isEmpty()) {
            parents = new ArrayList<>(children);
            children.clear();
            while(!parents.isEmpty()) {
                parent = parents.remove(0);
                string += parent.value.toString() + " ";
                if (parent.left != null)
                    children.add(parent.left);
                if (parent.right != null)
                    children.add(parent.right);
            }
            string += '\n';
        }
        return string;
    }

    public void append(T value) {
        var node = new Node<>(value);
        if (root == null)
            root = node;
        else {
            var current = root;
            while (value.compareTo(current.value) > 0 && current.right != null || value.compareTo(current.value) < 0 && current.left != null) {
                while (value.compareTo(current.value) > 0 && current.right != null)
                    current = current.right;
                while (value.compareTo(current.value) < 0 && current.left != null)
                    current = current.left;
            }
            // Now the value could be either equal to current.value, or else
            if (value.compareTo(current.value) < 0)
                current.left = node;
            else if (value.compareTo(current.value) > 0)
                current.right = node;
            else return; // Do nothing if value is redundant
        }
        size++;
    }


    public ArrayList<T> sorted() {
        var sorted_array = new ArrayList<T>();
        var stack = new Stack<Node<T>>();

        var current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        while(!stack.isEmpty()) {
            current = stack.peek();
            sorted_array.add(current.value);
            stack.pop();
            if (current.right != null)
                stack.push(current.right);
        }
        return sorted_array;
    }
}
