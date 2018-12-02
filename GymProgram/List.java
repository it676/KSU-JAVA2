/*
 *  Written By NAIF ALSHEHRI
 *  https://VisionAcademy.online
 *  All Rights Reserved@2011-2018
 */

/**
 *
 * @author IT676
 */
public class List {

    //Data 
    private Node head;//pointer to the first node in the list

    private int size;//the length of the LinkedList 

    //Oerations 
    public List() {

        head = null;
        size = 0;
    }

    public boolean isEmpty() {

        return head == null;
    }

    public int size() {

        return size;
    }

    public void insertAtFront(Gym obj) {

        Node newNode = new Node(obj);
        newNode.setNext(head);

        head = newNode;//update the head 

        size++;

    }

    public void insertAtBack(Gym obj) {
        //create the new node 
        Node newNode = new Node(obj);
        newNode.setNext(null);//always if null - last node

        Node current = head;

        if (isEmpty()) {

            head = newNode;

        } else {

            //move(traverse) to the last node of the linkedlist and then stop
            while (current.getNext() != null) {

                current = current.getNext();
            }

            current.setNext(newNode);

        }
        size++;

    }

    public Gym removeFromFront() {

        if (isEmpty()) {

            return null;
        }

        Node temp = head;

        Gym gym = temp.getData();

        head = head.getNext();

        size--;

        return gym;

    }

    public Gym removeFromBack() {

        if (isEmpty()) {

            return null;
        }
        if (size == 1) {

            Gym gym = head.getData();

            head = null;
            size--;
            return gym;
        }

        Node current = head;
        Node prev = current;

        while (current.getNext() != null) {

            prev = current;
            current = current.getNext();
        }

        prev.setNext(null);
        Gym gym = current.getData();
        size--;
        return gym;

    }

}
