package system.menu.student;

import system.data.course.Course;
import system.data.grade.PendingGrade;
import system.data.person.Student;
import system.data.person.Teacher;

import java.util.List;

public class MStudent implements IStudent{

    @Override
    public void showAvailableCourses(List<Course> courses, List<Teacher> teachers) {
        System.out.println("=== All Available Courses ===");
        courses.forEach(course -> {
            Teacher t = null;
            for(Teacher teacher: teachers){
                if(teacher.getCourseList().contains(course)){
                    t = teacher;
                }
            }
            if(t != null){
                System.out.println("Course id: " + course.getId() + "  Name: " + course.getName() + "  Teacher: " + t.getName());
            } else {
                System.out.println("Course id: " + course.getId() + "  Name: " + course.getName());

            }
        });



    }

    @Override
    public void showEnrolledCourses(List<Course> courses, Student student) {
        System.out.println("=== Your Enrolled Courses ===");
        student.getGrades().forEach(grade -> {
            if (grade instanceof PendingGrade){
                for(Course course: courses){
                    if (course.getId()== grade.getCourseId()){
                        System.out.printf("Course id: %d  Name: %s %n", course.getId(), course.getName());
                    }
                }
            }
        });
    }

    @Override
    public void showCompletedCourses(List<Course> courses, Student student) {
        System.out.println("=== Your Completed Courses ===");
        student.getGrades().forEach(grade -> {
            if (!(grade instanceof PendingGrade)){
                for(Course course: courses){
                    if (course.getId()== grade.getCourseId()){
                        System.out.printf("Course id: %d  Name: %s  Grade: %s %n", course.getId(), course.getName(), grade.getValue());
                    }
                }
            }
        });
    }
}
