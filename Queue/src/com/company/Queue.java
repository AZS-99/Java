package com.company;

import java.util.ArrayList;

public class Queue<T> {
    ArrayList<T> queue;

    Queue(){
        queue = new ArrayList<>();
    }

    public void enqueue(T value) {
        queue.add(value);
    }

    public T pop() {
        return queue.remove(0);
    }

    public boolean is_empty() {
        return queue.size() == 0;
    }
}
