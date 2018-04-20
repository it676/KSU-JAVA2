package queue;



/**
 *
 * @author IT676
 */
public class LinkedBasedQueue<E> implements Queue<E> {

    private Node<E> front;

    private Node<E> rear;

    private int size;

    public LinkedBasedQueue() {

        front = rear = null;

        size = 0;
    }

    @Override
    public boolean isEmpty() {

        return front == null;
        //return size ==0;
    }

    @Override
    public int size() {

        return size;

    }

    @Override

    public void enqueue(E item) {

        Node<E> newNode = new Node<>(item, null);

        if (isEmpty()) {

            front = rear = newNode;
        } else {
            rear.setNext(newNode);

            rear = newNode;
        }

        size++;
    }

    @Override

    public E front() {

        if (isEmpty()) {
            return null;
        }

        return front.getData();

    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            return null;
        }

        E item = front.getData();
        front = front.getNext();

        if (front == null) {
            rear = null;
        }

        size--;

        return item;

    }

}
