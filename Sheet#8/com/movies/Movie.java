
 package  com.movies;

/**
 *
 * @author IT676
 */
public class Movie {
    
    
    private int id;
    private String name;
    private String genre;
    private int year;

    public Movie(int id, String name, String genre, int year) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", genre=" + genre + ", year=" + year + '}';
    }
    
    
    
   
    
}
