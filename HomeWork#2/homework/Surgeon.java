package homework;

/**
 *
 * @author IT676
 */
public class Surgeon extends Employee {

    private int numOfOperations;

    public Surgeon(int id, String name, int numOfOperations) {

        super(id, name);
        this.numOfOperations = numOfOperations;
    }

    public int getNumOfOperations() {

        return numOfOperations;

    }

 

    @Override
    public double calculateSalary() {

        return this.getNumOfOperations() * 500 * 30;
    }
}
