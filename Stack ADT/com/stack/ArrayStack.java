package com.stack;

public class ArrayStack<E> implements Stack<E> {

    private final E[] stack;
    private int top;

    public ArrayStack(int size) {

        stack = (E[]) new Object[size];

        top = -1;
    }

    @Override
    public boolean isEmpty() {

        return (top == -1);

    }

    @Override
    public int size() {

        return top + 1;
    }

    @Override
    public void push(E item) {

        if (top == stack.length - 1) {

            throw new StackOverFlowException("Stack is overflow !");
        }

        stack[++top] = item;

    }

    //get the item at the top of the stack without removing it 
    public E top() {

        if (isEmpty()) {
            return null;
        }

        return stack[top];

    }

    @Override
    public E pop() {

        if (isEmpty()) {

            return null;
        }

        return stack[top--];

    }

}
