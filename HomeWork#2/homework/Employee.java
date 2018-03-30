package homework;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    protected int id;
    protected String name;

    public Employee(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public abstract double calculateSalary();

    
    public void diplay() {

        System.out.printf("Id : %d , Name : %s  ", id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
}
