

import java.util.Scanner;
public class BookStoreApp {
    
    
    public static void main(String[] args) {
        
        BookStore   bookStore = new BookStore("Jarir Book Store " , "Alolaya" , 100);
        
        
        Scanner input = new Scanner(System.in);
        
        int  choice;
        
        do {
            
              System.out.print("1-Add\n"
                      + "2-Remove\n"
                      + "3-Find and Print\n"
                      + "4-Display\n"
                      + "5-Exit\n"
                      + ">>");
              
              choice=input.nextInt();
                   
              
              switch (choice) {
                case 1:
                    
                   
                        System.out.print("Enter ISBN:");
                        int isbn=input.nextInt();
                        input.nextLine();
                       System.out.print("Enter Title:");
                        String title=input.nextLine();
                            
                        System.out.print("Enter Author:");

                        String author = input.nextLine();
                         System.out.print("Enter Category:");
                        
                         String category = input.nextLine();

                  
                         boolean isAdded =bookStore.addBook(new Book(isbn , title , author , category));
                         
                         System.out.println(isAdded?"Book has been added..":"Failed to add the book !");
                          
                      break;
                    
                      case 2:
                    
                      System.out.print("Enter ISBN:");
                      boolean isRemoved= bookStore.removeBook(input.nextInt());
                      System.out.println(isRemoved?"Book has been removed..":"Book was not Found 1");

                    break;
                    
                case 3: 
                     System.out.print("Enter Category:");
                     
                     Book[] foundBooks= bookStore.searchByCategory(input.nextLine());
                     
                     if(foundBooks==null)
                         System.out.println("No Books Found !");
                     else
                     
                     {
                     
                         for (int i = 0; i < foundBooks.length; i++) {
                        
                         System.out.println(foundBooks[i]);//call to toString method
                    }
                     }
                    break;
                    
                case 4: 
                    
                    bookStore.display();
                    
                    break;
                    
                case 5: 
                    break;
                    
                default:
                    System.out.println("Invalid Choice !");
            }
              
            
        } while (choice!=5);
        
        
        
        
    }
    
    
}
