package service;

import model.Course;
import model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService {

    private final Map<String, Student> students = new HashMap<>();

    // subscribeStudent
    public void subscribeStudent(Student student) {
        students.put(student.getId(), student);
    }
    // findStudent
    public Student findStudent(String studentId) {
        if(students.containsKey(studentId)) {
            return students.get(studentId);
        }
        return null;
    }

    // enrollStudentToCourse
    public void enrollStudentToCourse (String studentId, Course course) {
        // check that student exists
        if(!students.containsKey(studentId)) {
            // enroll student to course
            students.get(studentId).enrollToCourse(course);
        }
    }
    // check if the student is subscribed
    public boolean isSubscribed(String studentId) {
        return students.containsKey(studentId);
    }

    public void showSummary() {
        // TODO

    }
}
