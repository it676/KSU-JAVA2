
import java.util.Scanner;

/**
 *
 * @author IT676
 */
public class Course implements java.io.Serializable {

    private int cNo;
    private String cCode;
    private String name;
    private int creditHours;

    private String[] studentsArray;
    private int nbs;

    public Course(int cNo, String cCode, String name, int creditHours, int size) {

        while (cNo < 111 || cNo > 499) {

            Scanner input = new Scanner(System.in);
            try {

                System.out.println("Enter a valid course Number !");
                cNo = input.nextInt();

                if (cNo < 111 || cNo > 499) {
                    throw new InvalidCourseNoException("Invalid course No !");
                }

                break;//optional

            } catch (InvalidCourseNoException ex) {

                System.out.println("error : " + ex.toString());
            }
        }

        this.cNo = cNo;

        this.cCode = cCode;

        this.name = name;

        this.creditHours = creditHours;
        studentsArray = new String[size];
        nbs = 0;
    }

    public boolean addStudent(String name) {

        if (nbs == studentsArray.length) {
            return false;
        }

        studentsArray[nbs++] = name;
        return true;

    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public boolean equals(Course c) {

        if (c != null) {

            if (this.cNo == c.cNo && this.cCode.equals(c.cCode)) {

                return true;
            }
        }

        return false;

    }

    @Override
    public String toString() {

        String courseInfo = "";
        courseInfo = courseInfo.concat("Course No:" + this.cNo);
        courseInfo = courseInfo.concat("\nCourse Cose:" + this.cCode);
        courseInfo = courseInfo.concat("\nCourse Name:" + this.name);
        courseInfo = courseInfo.concat("\nCourse Hours:" + this.creditHours);
        courseInfo = courseInfo.concat("\n--------Students--------");

        for (int i = 0; i < nbs; i++) {

            courseInfo = courseInfo.concat("\n" + studentsArray[i]);

        }
        courseInfo = courseInfo.concat("\n----------------------");

        return courseInfo;
    }

}
