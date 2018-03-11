
/**
 *
 * @author IT676
 */
public abstract class GeometricObject {

    //we need to set default valeus 
    private String color = "white";
    private boolean filled = false;
    private String dateCreated = "01/03/2018";

    public GeometricObject() {
        
        /* 
        no need to init instance varables again 
        they have default values already declared 
                */
    }

    public GeometricObject(String color, boolean filled) {

        setColor(color);
        setFilled(filled);
    }

    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public abstract double getPerimeter();

    public abstract double getArea();

    @Override
    public String toString() {

        return String.format("Color : %s  , isFilled ? %s , Date Created :%s",
                             getColor() , (isFilled()?"Yes":"No") , getDateCreated());
    }
}
