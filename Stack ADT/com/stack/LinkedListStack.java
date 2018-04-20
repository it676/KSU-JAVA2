package com.stack;

/**
 *
 * @author IT676
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    private final LinkedList<E> list = new LinkedList<>();

    @Override
    public boolean isEmpty() {

        return list.isEmpty();

    }

    @Override
    public int size() {

        return list.size();
    }

    @Override
    public void push(E item) {

        list.addFront(item);
    }

    @Override
    public E top() {

        return list.getHead();
    }

    @Override
    public E pop() {

        return list.removeHead();
    }

}
