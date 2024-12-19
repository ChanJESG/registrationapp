package service;

import model.Course;
import model.Student;
import model.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseService {

    private final Map<String, Course> courses = new HashMap<>();                    // stores courses in the app

    private final Map<String, List<Student>> enrolledStudents = new HashMap<>();    // stores list of students in the app

    public CourseService() {

        Module module = new Module("INTRO-CS", "Introduction to Computer Science",
                "Introductory module for the generation technical programs");
        registerCourse(new Course("s", "Introduction to Computer Science", 9, module));
        registerCourse(new Course("INTRO-CS-2", "Introduction to Algorithms", 9, module));
        registerCourse(new Course("INTRO-CS-3", "Algorithm Design and Problem Solving - Introduction ", 9, module));
        registerCourse(new Course("INTRO-CS-4", "Algorithm Design and Problem Solving - Advanced", 9, module));
        registerCourse(new Course("INTRO-CS-5", "Terminal Fundamentals", 9, module));
        registerCourse(new Course("INTRO-CS-6", "Source Control Using Git and Github", 9, module));
        registerCourse(new Course("INTRO-CS-7", "Agile Software Development with SCRUM", 9, module));

        Module moduleWebFundamentals = new Module("INTRO-WEB", "Web Development Fundamentals",
                "Introduction to fundamentals of web development");
        registerCourse(new Course("INTRO-WEB-1", "Introduction to Web Applications", 9, moduleWebFundamentals));
        registerCourse(new Course("INTRO-WEB-2", "Introduction to HTML", 9, moduleWebFundamentals));
        registerCourse(new Course("INTRO-WEB-3", "Introduction to CSS", 9, moduleWebFundamentals));
        registerCourse(new Course("INTRO-WEB-4", "Advanced HTML", 9, moduleWebFundamentals));
        registerCourse(new Course("INTRO-WEB-5", "Advanced CSS", 9, moduleWebFundamentals));
        registerCourse(new Course("INTRO-WEB-6", "Introduction to Bootstrap Framework", 9, moduleWebFundamentals));
        registerCourse(
                new Course("INTRO-WEB-7", "Introduction to JavaScript for Web Development", 9, moduleWebFundamentals));

    }

    // store a course into courses by key: course.code, value: course
    public void registerCourse(Course course) {

        courses.put(course.getCode(), course);
    }

    // getting a course
    public Course getCourse(String code) {
        if(courses.containsKey(code))
            return courses.get(code);
        return null;
    }

    // enroll a student
    public void enrollStudent(String courseID, Student student) {
        // if courseID is not found in enrollStudent
        if(!courses.containsKey(courseID)) {
            // put (add) the courseID to enrollStudents, and instantiate a new ArrayList
            enrolledStudents.put(courseID, new ArrayList<>());
        }
        // then, we add the student to the ArrayList, after getting the courseID (do not put a new courseID and instantiate a new ArrayList if courseID is found)
        enrolledStudents.get(courseID).add(student);
    }

    // show all enrolled students

    public void showEnrolledStudents (String courseID) {
        // if key courseID exists in enrolledStudents
        if (enrolledStudents.containsKey(courseID)) {
            // get all the students as a List
            List<Student> students = enrolledStudents.get(courseID);
            // iterate through the list and print each student's info
            students.forEach(student -> {
                System.out.println(student);
            });
        }
    }

    // show summary of courses and enrolled students
    public void showSummary() {
        System.out.println("Available courses: ");
        // iterate through the courses' key
        for (String key: courses.keySet()) {
            // get each course by its key and store it to local variable course
            Course course = courses.get(key);
            // print the course retrieved from each key
            System.out.println(course);
        }

        System.out.println("Enrolled students: ");
        // iterate through the courses found in enrolledStudents
        for(String key: enrolledStudents.keySet()) {
            // store the students from each key (courseID)
            List<Student> students = enrolledStudents.get(key);
            System.out.println("Students in Course Code:" + key);
            // iterate through the returned students by its courseID
            for(Student student: students) {
                // print out the student
                System.out.println(student);
            }
        }
    }
}

