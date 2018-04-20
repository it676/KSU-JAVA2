
/**
 *
 * @author IT676
 */
//LinkedList ADT 
//ADT = Data + Operations (methods)
public class LinkedList {

    //Data 
    private Node head;//pointer to the first node in the list
    private Node tail;//pointer to the last node in the list - optioanl

    private int size;//the length of the LinkedList 

    //Oerations 
    public LinkedList() {

        head = tail = null;
        size = 0;
    }

    public boolean isCoursempty() {

        return head == null;
    }

    public int size() {

        return size;
    }

    //add methods  - addFront   - addBack
    public void addFront(Course item) {

        Node newNode = new Node(item);

        newNode.setNext(head);

        if (isCoursempty()) {

            head = tail = newNode;
        } else {

            head = newNode;//update the head 
        }

        size++;

    }

    public boolean isEmpty() {

        return head == null;
    }

    public void addTail(Course item) {

        Node newNode = new Node(item);

        newNode.setNext(null);//always if null - last node

        if (isCoursempty()) {

            head = tail = newNode;

        } else {
            tail.setNext(newNode);

            tail = newNode;//update the tail

        }
        size++;

    }

    public void addLastWithoutUsingTailReference(Course item) {

        Node newNode = new Node(item);//create the node

        //set the item - data
        newNode.setData(item);

        //set the next to null - since it's the last node --> alwayes null
        newNode.setNext(null);

        if (isCoursempty()) {

            head = newNode;

        } else {

            //traverse till access the old last node 
            Node current = head;

            while (current.getNext() != null) {

                current = current.getNext();
            }

            current.setNext(newNode);//link the new node to the list
        }

        tail = tail.getNext();// bad practice 
        size++;

    }

    public void addAfter(Course item, Course after) {

        if (isCoursempty()) {

            this.addFront(item);
            return;
        }

        //find the node to add after 
        Node current = head;

        while (current != null && !current.getData().equals(after)) {

            //upate the current
            current = current.getNext();

        }

        if (current == null) {

            this.addTail(item);
            return;
        }

        Node newNode = new Node(item);
        newNode.setData(item);
        newNode.setNext(current.getNext());

        current.setNext(newNode);
        //create the new node 

        size++;
        //link the new node
        //update the affected nodes
        //update the size
    }

    public Course getHead() {

        if (isCoursempty()) {
            return null;
        }

        return head.getData();
    }

    public Course getTail() {

        if (isCoursempty()) {

            return null;
        }

        return tail.getData();
    }

    public Course getTailWithoutTailReferece() {

        if (isCoursempty()) {

            return null;
        }

        Node current = head;

        while (current.getNext() != null) {

            current = current.getNext();
        }

        return current.getData();
    }

    public boolean search1(Course key) {

        Node current = head;

        while (current != null) {

            if (current.getData().equals(key)) {
                return true;
            }

            //update the current
            current = current.getNext();
        }

        return false;

    }

    public Node search2(Course key) {

        Node current = head;

        while (current != null) {

            if (current.getData().equals(key)) {
                return current;
            }

            current = current.getNext();
        }

        return null;

    }

    public void printListUsingForLoop() {

        Node current = head;

        for (int i = 0; i < this.size(); i++) {

            System.out.println(current.getData());

            current = current.getNext();

        }
    }

    public void printList() {

        if (isCoursempty()) {

            System.out.println("list is empty !");
        }
        //traverse the list 
        Node current = head;

        while (current != null) {

            System.out.print(current.getData() + " ,  ");

            //update the current 
            current = current.getNext();
        }
        System.out.println("");
    }

    public Node getFirstNode() {

        return head;
    }

    public Course removeHead() {

        if (isCoursempty()) {

            return null;
        }

        Node temp = head;

        Course item = temp.getData();

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

    public Course removeTail() {

        if (isCoursempty()) {

            return null;
        }

        if (head == tail) {

            size--;
            Course item = head.getData();

            head = tail = null;
            return item;

        }

        Node current = head;
        while (current.getNext().getNext() != null) {

            current = current.getNext();
        }

        Course item = current.getNext().getData();

        current.setNext(null);

        tail = current;

        size--;

        return item;

    }

    public Course removeTailVersion2() {
        if (isCoursempty()) {

            return null;
        }

        if (head == tail) {

            size--;
            Course item = head.getData();

            head = tail = null;
            return item;
        }

        Node current = head;

        Node prev = current;

        while (current.getNext() != null) {

            prev = current;
            current = current.getNext();
        }

        prev.setNext(null);
        tail = prev;

        return current.getData();

    }

    public int size2() {

        int counter = 0;
        Node current = head;

        while (current != null) {

            counter++;
            current = current.getNext();
        }

        return counter;

    }

}
