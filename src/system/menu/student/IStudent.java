package system.menu.student;

import system.data.course.Course;
import system.data.person.Student;
import system.data.person.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface IStudent {
    void showAvailableCourses(List<Course> courses, List<Teacher> teachers);
    void showEnrolledCourses(List<Course> courses, Student student);
    void showCompletedCourses(List<Course> courses, Student student);
    void enrollCourse (List<Course> courses, List<Teacher> teachers, Student student, BufferedReader br) throws IOException;
    void disEnrollCourse (List<Course> courses, List<Teacher> teachers, Student student, BufferedReader br);
}
