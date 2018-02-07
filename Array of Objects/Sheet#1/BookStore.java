


public class BookStore {
    
    
    private String name;
    private String location;
    
    private Book[]  bookList;
    
    private int numOfBooks;
    
    
    public BookStore(String name , String location , int size){
        
        
        this.name=name;
        this.location=location;
        
        //Create the aray 
        bookList = new Book[size];
        numOfBooks=0;
    }
    
    public boolean addBook(Book b){
        
        if(numOfBooks == bookList.length)
            return false;
        
        bookList[numOfBooks++] = b;
        return true;
    }
    
    
    public boolean removeBook(int isbn){

        for (int i = 0; i <numOfBooks; i++) {
   
            
            if(isbn == bookList[i].getIsbn()){
                
                bookList[i] = bookList[numOfBooks-1];
                
                bookList[--numOfBooks]=null;
                
                return true;
   
            }
      
            }//end loop
  
        return false;
    }
    
    
    public Book[] searchByCategory(String category){
        
        int size=0;
        
        for (int i = 0; i <numOfBooks; i++) {
            
            
            if(category.equals(bookList[i].getCategory())){
                
                size++;
            }
        }//end loop
        if(size==0)
            return null;
        
        Book[] books = new Book[size];
        
        for (int i  = 0 , j=0; i < numOfBooks && j<books.length; i++) {
            
            if(category.equals(bookList[i].getCategory())){
                
               books[j] = bookList[i];
               j++;
               
            }
            
        }
 
        return books;
    }
    
    public void display(){
        
        for (int i = 0; i <numOfBooks; i++) {
            
            System.out.println(bookList[i].toString());
        }
    }
    
}
