package model;

import java.util.*;

public class Student extends Person implements Evaluation {

    private double average;                                                         // student class can also have its own attributes

    private final List<Course> courses = new ArrayList<>();                         // student has a list of courses that they attend

    private final Map <String, Course> approvedCourses = new HashMap<>();           // student has a list of approved courses that they attend

    public Student(String id, String name, String email, Date DOB) {
        // super is used to reference the parent's classes attributes and methods - where inheritance is implied
        super(id, name, email, DOB);
        average = 0.0;
    }

    public Student(String id, String name, String email, Date DOB, double average) {
        super(id, name, email, DOB);
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void enrollToCourse(Course course) {

    }

    public void registerApprovedCourse() {

    }

    public boolean isCourseApproved(Course course) {
        return false;
    }

    // we override toString() method, otherwise parent class method is used
    @Override
    public String toString() {
        return String.format(
                "{id: %s, name: %s, email: %s, DOB: %s, average GPA: %.2f}",
                super.getId(),
                super.getName(),
                super.getEmail(),
                super.getDOB(),
                this.average
        );
    }

    @Override
    public List<Course> getApprovedCourses() {
        return List.of();
    }
}
