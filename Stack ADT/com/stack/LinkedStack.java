package com.stack;

/**
 *
 * @author IT676
 * @param <E>  item type to insert
 */
public class LinkedStack<E> implements Stack<E> {

    private Node<E> head;
    private int size;

    public LinkedStack() {

        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {

        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E item) {

        Node<E> newNode = new Node<>(item, head);

        head = newNode;

        size++;

    }

    @Override
    public E pop() {

        if (isEmpty()) {

            return null;
        }
        Node<E> nodeToRemove = head;

        head = nodeToRemove.getNext();

        E itemToRemove = nodeToRemove.getItem();
        nodeToRemove.setNext(null);
        size--;
        nodeToRemove = null;//to help GC

        return itemToRemove;
    }

    @Override
    public E top() {

        if (isEmpty()) {
            return null;
        }

        return head.getItem();
    }
}
