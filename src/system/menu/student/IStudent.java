package system.menu.student;

import system.data.course.Course;
import system.data.person.Student;
import system.data.person.Teacher;

import java.util.List;

public interface IStudent {
    void showAvailableCourses(List<Course> courses, List<Teacher> teachers);
    void showEnrolledCourses(List<Course> courses, Student student);
}
