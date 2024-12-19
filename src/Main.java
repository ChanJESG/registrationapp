import model.Person;
import model.Student;
import service.CourseService;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("1", "Student A", "studentA@gmail.com", new Date("11/22/2000"));
        System.out.println(student1);

        Student student2 = new Student("2", "Student B", "studentB@gmail.com", new Date("12/12/2000"), 3.5);
        System.out.println(student2);

        // print out only the average GPA of student 2
        System.out.println(student2.getAverage());

        // change the average GPA of student 2
        student2.setAverage(3.2);
        System.out.println(student2.getAverage());


    }
}