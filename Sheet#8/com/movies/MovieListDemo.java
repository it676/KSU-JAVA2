package com.movies;

/**
 *
 * @author IT676
 */
public class MovieListDemo {

    public static void main(String[] args) {

        //a
        MovieList movieList = new MovieList();

        //b
        Movie movie1 = new Movie(11, "Mother", "Drama", 2017);
        Movie movie2 = new Movie(22, "The Room", "Drama", 2003);
        Movie movie3 = new Movie(33, "The Avengers", "Action", 2012);

        //c
        movieList.insertAtFront(movie3);
        movieList.insertAtFront(movie1);

        //d
        boolean isAdded = movieList.insertAfter(movie2, 11);
        if (isAdded) {
            System.out.println("added succ...");
        } else {
            System.out.println("not added !");
        }

        //e
        System.out.println("Number of Movies : " + movieList.count());

        //f
        Movie[] dramaMovies = movieList.searchMovies("Drama");

        if (dramaMovies !=null && dramaMovies.length > 0) {

            for (Movie m : dramaMovies) {

                System.out.println(m);
            }
        } else {

            System.out.println("no drama movies found !");
        }

        //g
        Movie m = movieList.removeMovie("The Room");

        if (m != null) {

            System.out.println("Moview Info :");
            System.out.println(m);
        } else {

            System.out.println("error during removing , movie was not found !");
        }
        
        
        //h
        
        movieList.displayAll();
    }
}
