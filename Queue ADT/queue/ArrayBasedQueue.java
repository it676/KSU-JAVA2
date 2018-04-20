package queue;


//Queue ADT  = Data + operations
/**
 *
 * @author IT676
 * @param <E>
 */
public class ArrayBasedQueue<E> implements Queue<E> {

    //Data
    private final  E[] queue;

    private int rear;//counter of index

    private int size;//the number of items in the queue

  

    public ArrayBasedQueue(int size) {

      
        queue = (E[]) new Object[size];

        rear = -1;

        size = 0;
    }

    @Override
    public boolean isEmpty() {

        return rear == -1;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void enqueue(E item) {

        if (rear == queue.length - 1) {

            throw new IllegalStateException("Qeuue if Full !");

        }

        queue[++rear] = item;

        size++;

    }

    @Override
    public E dequeue() {

        if (isEmpty()) {

            return null;
        }

        E itemToRemove = queue[0];

        for (int i = 0; i < queue.length - 1; i++) {

            queue[i] = queue[i + 1];
        }

        rear--;
        size--;

        return itemToRemove;

    }

    @Override
    public E front() {

        if (isEmpty()) {

            return null;
        }

        return queue[0];
    }
}
