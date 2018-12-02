/*
 *  Written By NAIF ALSHEHRI
 *  https://VisionAcademy.online
 *  All Rights Reserved@2011-2018
 */

/**
 *
 * @author IT676
 */
public class Node {

    private Gym data;

    private Node next;

    public Node(Gym obj) {

        data = obj;

    }

    public Gym getData() {
        return data;
    }

    public void setData(Gym data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
