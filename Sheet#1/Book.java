




public class Book {
    
    //instance variables
    private int  isbn;
    private String title;
    private String author;
    private String category;
    
    
    //constructors
    
    
    //no-args cons
    public Book(){
        
      isbn=0;
      title="";
      author="";
      category="";
    }
    
    
    //para  cons
    public Book(int isbn , String title  , String author  , String category){
        
        
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.category=category;
    }
    
    
    
    //copy cons
    public Book(Book  b){
        
       this.isbn =  b.getIsbn();
       
       this.title=b.getTitle();
       
       this.author=b.getAuthor();
       
       this.category = b.getCategory();
        
    }
    //setters
    
    
    //getters
    
    
    //toString

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString(){
        
        return String.format("Book's ISBN:%d\tBook's Title:%s\tBook's Author:%s\tBook's Category:%s",
                               getIsbn() , getTitle()  , getAuthor()  , getCategory());
    }
    
    
}