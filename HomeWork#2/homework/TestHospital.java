package homework;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 *
 * @author IT676
 */
public class TestHospital {

    public static void main(String[] args) {

        Hospital hospital = new Hospital("GreenLife", "Riyadh", 6);

        hospital.addEmployee(new Surgeon(123, "Ahmad", 10));
        hospital.addEmployee(new Nurse(678, "Amal", 10));
        hospital.addEmployee(new Nurse(890, "Sara", 9));
        hospital.addEmployee(new Nurse(994, "Mary", 8));
        hospital.addEmployee(new Surgeon(144, "Nora", 6));
        hospital.addEmployee(new Nurse(734, "Kate", 12));

        String fileName = "EmployeesList.data";
        try {

            hospital.saveAllEmpToFile(fileName);

            double totalSalaries = hospital.readAllEmpFromFile(fileName);

            System.out.printf("Sum of Employees Salaries is :%.2f%n", totalSalaries);

            for (Employee emp : hospital.getEmployeesWithSalary(10000, 15000)) {

                emp.diplay();
                System.out.println();

            }

            System.out.printf("Average Salary of all Employees:%.2f%n ", hospital.calculateAvgSalary());

            //third employee is at index  2 
            hospital.getEmployeeAt(2).diplay();
            System.out.println();
            
            hospital.diplay();
           

        } catch (ArrayIndexOutOfBoundsException ex) {

           
            System.err.println("Error:Invalid Index  !");
        } catch (NullPointerException ex) {

           
            System.err.println("Error:Invalid Employee reference  !");
        } catch (FileNotFoundException ex) {

            //actulally the file will be created for us 
            System.err.println("Error: File Not Found !");
        
        } catch (IOException ex) {

            System.err.println("Can't process the file !");

        } catch (ClassNotFoundException ex) {

            System.err.println("Error while reading Data : Class Not Found  !");
        }
    }
}
