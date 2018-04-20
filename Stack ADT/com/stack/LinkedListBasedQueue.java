package com.stack;

/**
 *
 * @author IT676
 */
public class LinkedListBasedQueue<E> {

    private LinkedList<E> list = new LinkedList<>();

    public boolean isEmpty() {

        return list.isEmpty();
    }

    public int size() {

        return list.size();
    }

    public void enqueue(E item) {

        list.addTail(item);
    }

    public E front() {

        return list.getHead();
    }

    public E dequeue() {

        return list.removeHead();
    }
}
