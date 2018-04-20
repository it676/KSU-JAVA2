package linkedList;


/**
 *
 * @author IT676
 */

//LinkedList ADT 
//ADT = Data + Operations (methods)
public class LinkedList<E> {

    //Data 
    private Node<E> head;//pointer to the first node in the list
    private Node<E> tail;//pointer to the last node in the list - optioanl

    private int size;//the length of the LinkedList 

    //Oerations 
    public LinkedList() {

        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {

        return head == null;
    }

    public int size() {

        return size;
    }

    //add methods  - addFront   - addBack
    public void addFront(E item) {

        Node<E> newNode = new Node<>();
        newNode.setItem(item);
        newNode.setNext(head);

        if (isEmpty()) {

            head = tail = newNode;
        } else {

            head = newNode;//update the head 
        }

        size++;

    }

    public void addTail(E item) {

        Node<E> newNode = new Node<>();
        newNode.setItem(item);
        newNode.setNext(null);//always if null - last node

        if (isEmpty()) {

            head = tail = newNode;

        } else {
            tail.setNext(newNode);

            tail = newNode;//update the tail

        }
        size++;

    }

    public void addLastWithoutUsingTailReference(E item) {

        Node<E> newNode = new Node<>();//create the node

        //set the item - data
        newNode.setItem(item);

        //set the next to null - since it's the last node --> alwayes null
        newNode.setNext(null);

        if (isEmpty()) {

            head = newNode;

        } else {

            //traverse till access the old last node 
            Node<E> current = head;

            while (current.getNext() != null) {

                current = current.getNext();
            }

            current.setNext(newNode);//link the new node to the list
        }

        tail = tail.getNext();// bad practice 
        size++;

    }

    public void addAfter(E item, E after) {

        if (isEmpty()) {

            this.addFront(item);
            return;
        }

        //find the node to add after 
        Node<E> current = head;

        while (current != null && !current.getItem().equals(after)) {

            //upate the current
            current = current.getNext();

        }

        if (current == null) {

            this.addTail(item);
            return;
        }

        Node<E> newNode = new Node<>();
        newNode.setItem(item);
        newNode.setNext(current.getNext());

        current.setNext(newNode);
        //create the new node 

        size++;
        //link the new node
        //update the affected nodes
        //update the size
    }

    public E getHead() {

        if (isEmpty()) {
            return null;
        }

        return head.getItem();
    }

    public E getTail() {

        if (isEmpty()) {

            return null;
        }

        return tail.getItem();
    }

    public E getTailWithoutTailReferece() {

        if (isEmpty()) {

            return null;
        }

        Node<E> current = head;

        while (current.getNext() != null) {

            current = current.getNext();
        }

        return current.getItem();
    }

    public boolean search1(E key) {

        Node<E> current = head;

        while (current != null) {

            if (current.getItem().equals(key)) {
                return true;
            }

            //update the current
            current = current.getNext();
        }

        return false;

    }

    public Node<E> search2(E key) {

        Node<E> current = head;

        while (current != null) {

            if (current.getItem().equals(key)) {
                return current;
            }

            current = current.getNext();
        }

        return null;

    }

    public void printListUsingForLoop() {

        Node<E> current = head;

        for (int i = 0; i < this.size(); i++) {

            System.out.println(current.getItem());

            current = current.getNext();

        }
    }

    public Node<E> getNodeAtIndex(int index) {

        if (isEmpty()) {

            throw new IllegalStateException("LinkedLit is Empty !");
        }
        if (index < 0 || index >= size()) {

            throw new IllegalArgumentException("Invali node index ! must be between "
                    + "0 and " + (size() - 1));
        }

        Node<E> current = head;

        for (int i = 0; i < index; i++) {

            current = current.getNext();
        }

        return current;

    }

    public void printList() {

        if (isEmpty()) {

            System.out.println("list is empty !");
        }
        //traverse the list 
        Node<E> current = head;

        while (current != null) {

            System.out.print(current.getItem() + " ,  ");

            //update the current 
            current = current.getNext();
        }
        System.out.println("");
    }

    public E removeHead() {

        if (isEmpty()) {

            return null;
        }

        Node<E> temp = head;

        E item = temp.getItem();

        head = head.getNext();

        size--;
        //to help the GC

        if (head == null) {
            tail = null;
        } else {
            temp.setNext(null);

        }

        temp = null;

        return item;

    }

    public E removeTail() {

        if (isEmpty()) {

            return null;
        }

        if (head == tail) {

            size--;
            E item = head.getItem();

            head = tail = null;
            return item;

        }

        Node<E> current = head;
        while (current.getNext().getNext() != null) {

            current = current.getNext();
        }

        E item = current.getNext().getItem();

        current.setNext(null);

        tail = current;

        size--;

        return item;

    }

    public E removeTailVersion2() {
        if (isEmpty()) {

            return null;
        }

        if (head == tail) {

            size--;
            E item = head.getItem();

            head = tail = null;
            return item;
        }

        Node<E> current = head;

        Node<E> prev = current;

        while (current.getNext() != null) {

            prev = current;
            current = current.getNext();
        }

        prev.setNext(null);
        tail = prev;

        return current.getItem();

    }

    public int size2() {

        int counter = 0;
        Node<E> current = head;

        while (current != null) {

            counter++;
            current = current.getNext();
        }

        return counter;

    }

}
