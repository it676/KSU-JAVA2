package com.stack;

/**
 *
 * @author IT676
 */
public interface Stack<E> {

    public abstract boolean isEmpty();

    public abstract int size();

    public abstract void push(E item);

    public abstract E top();

    public abstract E pop();

}
