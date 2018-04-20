package linkedList;


/**
 *
 * @author IT676
 */
public class Node<E> {

    private E item;//data item

    private Node<E> next;

    public Node() {

    }

    public Node(E item) {

        this(item, null);

    }

    public Node(E item, Node<E> next) {

        this.item = item;

        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}
