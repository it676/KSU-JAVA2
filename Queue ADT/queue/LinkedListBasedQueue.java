package queue;

/**
 *
 * @author IT676
 */
public class LinkedListBasedQueue<E> implements Queue<E> {

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
    public void enqueue(E item) {

        list.addTail(item);
    }

    @Override
    public E dequeue() {

        return list.removeHead();
    }

    @Override
    public E front() {

        return list.getHead();
    }

}
