package homework;

import java.io.*;

/**
 *
 * @author IT676
 */
public class Hospital {

    private String name;
    private String city;
    private Employee[] empArray;
    private int numOfCurrEmp;

    public Hospital(String name, String city, int size) {

        this.name = name;
        this.city = city;
        if (size < 0) {
            throw new NegativeArraySizeException("Negative array size : " + size);
        }
        empArray = new Employee[size];
    }

    public boolean addEmployee(Employee e) {

        if (numOfCurrEmp == empArray.length) {
            return false;
        }

        if (e instanceof Nurse) {

            empArray[numOfCurrEmp++] = new Nurse(e.getId(), e.getName(), ((Nurse) e).getHours());

        } else if (e instanceof Surgeon) {

            empArray[numOfCurrEmp++] = new Surgeon(e.getId(), e.getName(), ((Surgeon) e).getNumOfOperations());
        } else {

            throw new IllegalArgumentException("Unknow Employee type :" + e.getClass().getSimpleName());
        }

        return true;

    }

    public Employee getEmployeeAt(int i) {

        if (i < 0 || i >= empArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Employee emp = empArray[i];

        if (emp == null) {
            throw new NullPointerException();
        }

        return emp;
    }

    public double calculateAvgSalary() {

        double totalSalaries = 0;

        for (Employee emp : empArray) {

            totalSalaries += emp.calculateSalary();
        }

        if (numOfCurrEmp == 0) {
            throw new ArithmeticException();
        }

        return totalSalaries / numOfCurrEmp;

    }

    public Employee[] getEmployeesWithSalary(double lower, double upper) {

        int size = 0;
        for (Employee emp : empArray) {

            double salary = emp.calculateSalary();
            if (salary >= lower && salary <= upper) {
                size++;
            }
        }

        Employee[] employeesWithRequiredSalary = new Employee[size];

        for (int i = 0, j = 0; i < empArray.length && j < size; i++) {
            double salary = empArray[i].calculateSalary();
            if (salary >= lower && salary <= upper) {
                employeesWithRequiredSalary[j++] = empArray[i];
            }

        }

        return employeesWithRequiredSalary;

    }

    public void diplay() {

        for (Employee emp : empArray) {

            emp.diplay();
            if (emp instanceof Nurse) {
                System.out.printf(", Hours: %d%n", ((Nurse) emp).getHours());
            }

            if (emp instanceof Surgeon) {
                System.out.printf(", Operations: %d%n", ((Surgeon) emp).getNumOfOperations());
            }
        }
    }

    public void saveAllEmpToFile(String fileName) throws FileNotFoundException, IOException {

        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Employee emp : empArray) {

            oos.writeObject(emp);
        }

    }

    public double readAllEmpFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        boolean contRead = true;

        Employee emp;

        double totalSalaries = 0;

        while (contRead) {
            try {

                emp = (Employee) ois.readObject();

                totalSalaries += emp.calculateSalary();

                
            } catch (EOFException ex) {

                //noraml termination 
                contRead = false;
            }

        }

        return totalSalaries;
    }

}


