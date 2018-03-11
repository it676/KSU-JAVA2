
/**
 *
 * @author IT676
 */
public class ComparableCircle extends Circle implements Comparable {

   
    public ComparableCircle() {
    
    }

    public ComparableCircle(double radius) {

        super(radius);

    }

    public ComparableCircle(double radius, String color, boolean filled) {

        super(radius, color, filled);
    }

    @Override
    public int compareTo(double area) {

        if (this.getArea() == area) {
            return 0;
        }

        if (this.getArea() > area) {
            return 1;
        }

        return -1;

    }

    @Override
    public String toString() {

        return String.format("%s", super.toString());
    }

}
