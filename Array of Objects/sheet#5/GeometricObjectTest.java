



/**
 *
 * @author IT676
 */
public class GeometricObjectTest {
    
    public static void main(String[] args) {
        
        
        //create two instances of ComparableCircle class
        GeometricObject firstCircle = new ComparableCircle(12.5 , "Red",true);
        
        GeometricObject secondCircle = new ComparableCircle(18.3 , "Blue" , true);
        
        
        //display circles info
        System.out.println("First Circle Info : "+firstCircle.toString());
        
        System.out.println("Second Circle Info : "+secondCircle.toString());
        
        System.out.println();//new line 
        
        //do downcasting to call compareTo method and store the comparison result
        int comparisonResult = ((ComparableCircle)firstCircle).compareTo(secondCircle.getArea());
        
        switch (comparisonResult) {
            case 0:
                   System.out.println("The areas of the two circles are equal !");
               
                 //display the two circles 
                  System.out.println("First Circle Info : "+firstCircle.toString());
                  System.out.println("Second Circle Info : "+secondCircle.toString());
                  //display the area of any one since they are same
                   System.out.printf("Area = %.2f%n",firstCircle.getArea());
                break;
                
            case 1 : 
                
                System.out.println("The Area of the First Circle is Larger than the area of the Second one !");
                System.out.println("First Circle Info : "+firstCircle.toString());
                System.out.printf("Area = %.2f%n",firstCircle.getArea());

                break;
                 
            
            case -1 : 
                System.out.println("The Area of the Second Circle is Larger than the area of the First one !");
                System.out.println("First Circle Info : "+secondCircle.toString());
                System.out.printf("Area = %.2f%n",secondCircle.getArea());

            
        }
        
         
    }
    
}
