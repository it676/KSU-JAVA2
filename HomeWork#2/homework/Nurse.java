package homework;

/**
 *
 * @author IT676
 */
public class Nurse extends Employee {

    private int hours;

    public Nurse(int id, String name, int hours) {

        super(id, name);
        this.hours = hours;

    }

    public int getHours() {
        return hours;
    }

    
    
    @Override
    public double calculateSalary() {

        return this.getHours() * 55 * 30;
    }
}
