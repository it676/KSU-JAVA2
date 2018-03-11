
/**
 *
 * @author IT676
 */
public class Circle extends GeometricObject {

    private double radius;

    public Circle() {

      this(0.0);
    }

    public Circle(double radius) {
      super();
      setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled) {

        super(color, filled);
        setRadius(radius);

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {

        return 2 * Math.PI * getRadius();
    }

    @Override
    public double getArea() {

    return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getDiameter() {

        return 2 * getRadius();
    }


    @Override
    public String toString(){
        
        //you can display all  data such as area , perimeter and Diameter
        return String.format("%s , Radius = %.2f ", super.toString(),getRadius());
    }

    
}
