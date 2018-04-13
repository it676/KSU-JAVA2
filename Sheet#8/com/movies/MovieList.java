package com.movies;

/**
 *
 * @author IT676
 */
public class MovieList {

    private Node head;

    public MovieList() {

        head = null;
    }

    public int count() {

        int counter = 0;
        Node current = head;

        while (current != null) {

            counter++;

            current = current.getNext();
        }

        return counter;

    }

    public boolean isEmpty() {

        return head == null;
    }

    public void displayAll() {

        if (isEmpty()) {
            System.out.println("No movies yet !");
            return;
        }

        System.out.println("Id\tName\tGenre\tYear");
        System.out.println("-----------------------------------"); 
        Node currentMovie = head;
        while (currentMovie != null) {

            System.out.printf("%d\t%s\t%s\t%d%n",
                    currentMovie.getData().getId(),
                    currentMovie.getData().getName(),
                    currentMovie.getData().getGenre(),
                    currentMovie.getData().getYear());
        System.out.println("------------------------------------");

            currentMovie = currentMovie.getNext();
        }

    }

    public void insertAtFront(Movie m) {

        Node newNode = new Node(m);

        newNode.setNext(head);

        head = newNode;
    }

    public boolean insertAfter(Movie m, int id) {

        if (isEmpty()) {

            return false;
        }

        Node currentMovie = head;

        while (currentMovie != null) {

            if (id == currentMovie.getData().getId()) {
                break;
            }

            currentMovie = currentMovie.getNext();
        }

        if (currentMovie == null) {
            return false;
        }

        Node newNode = new Node(m);

        newNode.setNext(currentMovie.getNext());

        currentMovie.setNext(newNode);

        return true;
    }

    public Movie removeMovie(String name) {

        if (isEmpty()) {
            return null;
        }

        //if the movie was in the first node
        if (head.getData().getName().equalsIgnoreCase(name)) {

            Movie m = head.getData();
            head = head.getNext();

            return m;

        }

        Node currentMovie = head;

        while (currentMovie.getNext() != null) {

            if (currentMovie.getNext().getData().getName().equalsIgnoreCase(name)) {

                break;
            }
            currentMovie = currentMovie.getNext();
        }

        Node nodeToDelete = currentMovie.getNext();

        Movie m = nodeToDelete.getData();

        currentMovie.setNext(nodeToDelete.getNext());

        nodeToDelete.setNext(null);

        nodeToDelete = null;
        return m;

    }

    private int getNumMoviesByGenre(String genre) {

        int size = 0;
        Node currentMovie = head;

        while (currentMovie != null) {

            if (currentMovie.getData().getGenre().equalsIgnoreCase(genre)) {
                size++;
            }

            currentMovie = currentMovie.getNext();
        }

        return size;
    }

    public Movie[] searchMovies(String genre) {

        int size = getNumMoviesByGenre(genre);

        if (size == 0) {
            return null;
        }

        Movie[] movies = new Movie[size];
        int index = 0;

        Node currentMovie = head;
        while (currentMovie != null) {

            if (currentMovie.getData().getGenre().equalsIgnoreCase(genre)) {

                movies[index++] = currentMovie.getData();

            }

            currentMovie = currentMovie.getNext();
        }

        return movies;

    }

    public Movie getMovie(int id) {

        Node currentMovie = head;

        while (currentMovie != null) {

            if (id == currentMovie.getData().getId()) {
                return currentMovie.getData();
            }

            currentMovie = currentMovie.getNext();
        }

        return null;

    }
}
