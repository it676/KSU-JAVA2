package com.movies;

/**
 *
 * @author IT676
 */
public class Node {

    private Movie data;
    private Node next;

    
    public Node(Movie m){
        
        this.data=m;
        next = null;
        
    }

    public Movie getData() {
        return data;
    }

    public void setData(Movie data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    
   
}
